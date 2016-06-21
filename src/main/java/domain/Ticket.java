package Domain;

/**
 * Created by Evgeny_Akulenko on 6/20/2016.
 */
public class Ticket {
    private static int id = 0;

    private int eventId;

    private int userId;

    private int seat;

    private boolean isBooked = false;

    Ticket(int eventId, int seat) {
        id = id++;
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

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
