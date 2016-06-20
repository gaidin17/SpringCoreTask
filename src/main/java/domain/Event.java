package Domain;

import Domain.Enums.Rating;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


/**
 * Created by Evgeny_Akulenko on 6/20/2016.
 */
public class Event {
    private static int id;

    private String name;

    private LocalDate date;

    private LocalTime time;

    private Double basePrice;

    private Rating rating;

    private List<Ticket> tickets;

    private Auditorium auditorium;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public Event(String name, String date, String time, Double basePrice, List<Ticket> tickets, Rating rating, Auditorium auditorium) {

        id = id++;
        this.name = name;
        this.date = LocalDate.parse(date);
        this.time = LocalTime.parse(time);
        this.tickets = tickets;
        this.basePrice = basePrice;
        this.rating = rating;
        this.auditorium = auditorium;
    }
}
