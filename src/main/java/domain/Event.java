package domain;

import domain.enums.Rating;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/20/2016.
 */
public class Event {
    private static int id = 0;

    private String name;

    private LocalDate date;

    private LocalTime time;

    private Double basePrice;

    private Rating rating;

    private List<Ticket> tickets;

    private Auditorium auditorium;

    public Event(String name, String date, String time, Double basePrice, Rating rating, Auditorium auditorium) {
        id++;
        this.name = name;
        this.date = LocalDate.parse(date);
        this.time = LocalTime.parse(time);
        this.basePrice = basePrice;
        this.rating = rating;
        this.auditorium = auditorium;
        this.tickets = createTickets();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public Ticket getTicketById(int id) {
        return getTickets().get(id);
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

    private List<Ticket> createTickets() {
        List<Ticket> ticketsList = new ArrayList<Ticket>();
        for (int i = 0; i < auditorium.getNumberOfSeats(); i++) {
            ticketsList.add(new Ticket(id, i));
        }
        return ticketsList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID: ").append(id).append("\n");
        builder.append("Name: ").append(name).append("\n");
        builder.append("Date, Time: ").append(date).append(", ").append(time).append("\n");
        builder.append("Base price: ").append(basePrice).append("\n");
        builder.append("Rating: ").append(rating).append("\n");
        builder.append("Number of Tickets: ").append(tickets.size()).append("\n");
        builder.append("Auditorium: ").append(auditorium.getName()).append("\n");
        return builder.toString();
    }

}
