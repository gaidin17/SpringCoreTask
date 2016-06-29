package aspects;

import domain.Event;
import domain.Ticket;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class CounterAspect {
    private static final Logger logger = LoggerFactory.getLogger(CounterAspect.class);
    private Map<String, Integer> counterGetEventByName = new HashMap<>();
    private Map<String, Integer> counterGetTicketPrices = new HashMap<>();
    private Map<Integer, Integer> counterBookTicket = new HashMap<>();

    public Map<String, Integer> getCounterGetEventByName() {
        return counterGetEventByName;
    }

    public void setCounterGetEventByName(Map<String, Integer> counterGetEventByName) {
        this.counterGetEventByName = counterGetEventByName;
    }

    public Map<String, Integer> getCounterGetTicketPrices() {
        return counterGetTicketPrices;
    }

    public void setCounterGetTicketPrices(Map<String, Integer> counterGetTicketPrices) {
        this.counterGetTicketPrices = counterGetTicketPrices;
    }

    public Map<Integer, Integer> getCounterBookTicket() {
        return counterBookTicket;
    }

    public void setCounterBookTicket(Map<Integer, Integer> counterBookTicket) {
        this.counterBookTicket = counterBookTicket;
    }

    @Pointcut("execution(* service.EventService.getByName(..))")
    private void eventServiceGetByNameMethod() {
    }

    @After("eventServiceGetByNameMethod() && args(name)")
    public void countEventGetByName(String name) {
        if (!counterGetEventByName.containsKey(name)) {
            counterGetEventByName.put(name, 0);
        }
        counterGetEventByName.put(name, counterGetEventByName.get(name)+1);
        logger.info("Counter service.EventService.getByName(): done");
    }

    @Pointcut("execution(* service.BookingService.getTicketPrices(..))")
    private void bookingServiceGetTicketPricesMethod() {
    }

    @After("bookingServiceGetTicketPricesMethod() && args(event)")
    public void countGetTicketPrices(Event event) {
        String eventName = event.getName();
        if (!counterGetTicketPrices.containsKey(eventName)) {
            counterGetTicketPrices.put(eventName, 0);
        }
        counterGetTicketPrices.put(eventName, counterGetTicketPrices.get(eventName)+1);
        logger.info("Counter service.BookingService.getTicketPrices: done");
    }

    @Pointcut("execution(* service.BookingService.bookTicket(..))")
    private void bookingServiceBookTicketMethod() {
    }

    @After("bookingServiceBookTicketMethod() && args(ticket)")
    public void countBookTicket(Ticket ticket) {
        int eventId = ticket.getEventId();
        if (!counterBookTicket.containsKey(eventId)) {
            counterBookTicket.put(eventId, 0);
        }
        counterBookTicket.put(eventId, counterBookTicket.get(eventId)+1);
        logger.info("Counter service.BookingService.bookTicket: done");
    }
}
