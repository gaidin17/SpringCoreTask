package DAO;

import java.util.Date;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class Ticket {
    private final Event event;
    private final Date date;
    private final int[] seats;

    public Event getEvent() {
        return event;
    }

    public Date getDate() {
        return date;
    }

    public int[] getSeats() {
        return seats;
    }

    public Ticket(Event event, Date date, int[] seats) {
        this.event = event;
        this.date = date;
        this.seats = seats;
    }
}
