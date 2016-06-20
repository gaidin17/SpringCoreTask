package Service;

import Domain.Event;
import Domain.Ticket;
import Domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class BookingService {
    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);
    private DiscountService discountService;
    private UserService userService;
    private EventService eventService;

    public double getTicketPrice(Event event, LocalDate date, LocalTime time, List<Integer> seats, User user) {
        double discount = discountService.getDiscount(user, event, date);
        double modificatorForVip = event.getAuditorium().getModificatorForVip();
        List<Integer> vipSeats = event.getAuditorium().getVipSeats();
        double price = 0d;
        for (Integer i : seats) {
            if (vipSeats.contains(i)) {
                price += (event.getBasePrice() - discount) * modificatorForVip;
            } else {
                price = event.getBasePrice() - discount;
            }
        }
        return price;
    }

    public void bookTicket(User user, Ticket ticket) {
        if (userService.getAll().contains(user)) {
            if (!ticket.isBooked()) {
                ticket.setBooked(true);
                ticket.setUserId(user.getId());
                user.addTicket(ticket);
            }
        } else {
            logger.warn("Warning: User is not registered");
        }
    }

    public List<Ticket> getTicketsForEvent(Event event) {
        List<Event> events = eventService.getAll();
        List<Ticket> bookedTickets = new ArrayList<Ticket>();
        if (events.contains(event)) {
            List<Ticket> tickets = event.getTickets();
            for (Ticket ticket : tickets) {
                if (ticket.isBooked()) {
                    bookedTickets.add(ticket);
                }
            }
        } else {
            logger.warn("Warning: event not found");
            return null;
        }
        return bookedTickets;
    }

}
