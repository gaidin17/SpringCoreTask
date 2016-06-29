package service;

import domain.Event;
import domain.Ticket;
import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class BookingService {
    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);
    private DiscountService discountService;
    private EventService eventService;
    private UserService userService;

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public double getTicketPrice(Event event, LocalDate date, List<Integer> seats, User user) {
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
        if (userService.getById(user.getId()) != null) {
            if (!ticket.isBooked()) {
                ticket.setBooked(true);
                ticket.setUserId(user.getId());
                user.addTicket(ticket);
                logger.info("Ticket is booked");
            } else {
                logger.warn("Warning: Ticket is allready booked");
            }
        } else {
            logger.warn("Warning: User is not registered");
        }
    }

    public List<Ticket> getTicketsForEvent(Event event) {
        List<Event> events = eventService.getAll();
        List<Ticket> bookedTickets = new ArrayList<>();
        if (events.contains(event)) {
            List<Ticket> tickets = event.getTickets();
            for (Ticket ticket : tickets) {
                if (ticket.isBooked()) {
                    bookedTickets.add(ticket);
                }
            }
        } else {
            logger.warn("Warning: event not found");
        }
        return bookedTickets;
    }

}
