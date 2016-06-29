package domain;

/**
 * Created by Evgeny_Akulenko on 6/20/2016.
 */
public class Ticket {
    private static int countId = 0;
    private int id;
    private int eventId;
    private int userId;
    private int seat;
    private double price;
    private boolean isBooked = false;

    Ticket(int eventId, int seat) {
        id = countId++;
        this.eventId = eventId;
        this.seat = seat;
    }

    public int getId() {
        return id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
