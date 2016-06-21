import Domain.Auditorium;
import Domain.Event;
import Domain.Ticket;
import Domain.User;
import Service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/20/2016.
 */
public class MainApp {
    private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

    public void setAuditoriumService(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private AuditoriumService auditoriumService;
    private BookingService bookingService;
    private DiscountService discountService;
    private EventService eventService;
    private UserService userService;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        MainApp mainApp = (MainApp) ctx.getBean("mainApp");
        mainApp.showAllAuditoriums();
        User user1 = (User) ctx.getBean("user1");
        User user2 = (User) ctx.getBean("user2");

        Ticket ticket = mainApp.getTicketById("beerFest", 5);
        mainApp.bookTicket(user1, ticket);
        mainApp.bookTicket(user2, ticket);
    }

    private List<Ticket> showBookedTickets(String userEmail) {
        User user = userService.getUserByEmail(userEmail);
        return userService.getBookedTickets(user);
    }

    private void remove(User user) {
        userService.remove(user);
    }

    private void showAllAuditoriums() {
        for (Auditorium auditorium : auditoriumService.getAuditoriums()) {
            logger.info("Auditorium: {}", auditorium.toString());
        }
    }

    private void showAllEvents() {
        showEvent(eventService.getAll());
    }

    private void showEvent(List<Event> events) {
        for (Event event : events) {
            logger.info("Event: {}", event.toString());
        }
    }

    private void showUsers(List<User> users) {
        for (User user : users) {
            logger.info("User: {}", user.toString());
        }
    }

    private void showAllUsers() {
        showUsers(userService.getAll());
    }

    private List<User> getUsersByName(String userName) {
        return userService.getUsersByName(userName);
    }


    private void showTicketPrices(Event event, User user, List<Integer> seats) {
        double price = bookingService.getTicketPrice(event, event.getDate(), seats, user);
        logger.info("Price for ticket: {}", price);
    }


    private void bookTickets(User user, List<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            bookTicket(user, ticket);
        }
    }

    private void bookTicket(User user, Ticket ticket) {
        logger.info("Try to book ticket");
        bookingService.bookTicket(user, ticket);
    }

    private List<Ticket> getTicketsForEvent(String eventName) {
        Event event = eventService.getByName(eventName);
        return bookingService.getTicketsForEvent(event);
    }

    private Event getEventByName(String name) {
        return eventService.getByName(name);
    }

    private User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    private void createUser(ConfigurableApplicationContext ctx, String name, String email,
                            String birthDay) {

        User user = ctx.getBean(User.class);

        user.setName(name);
        user.setEmail(email);
        user.setBirthDate(LocalDate.parse(birthDay));

        userService.register(user);
    }

    private Ticket getTicketById(String eventName, int id) {
        return eventService.getByName(eventName).getTicketById(id);
    }
}
