package domain;

import domain.enums.Rating;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/20/2016.
 */
@Entity(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @Temporal(TemporalType.TIME)
    private LocalTime time;

    @Column(name = "baseprice")
    private Double basePrice;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Transient
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "auditoriumid")
    private Auditorium auditorium;

    public Event() {

    }

    public Event(int id, String name, String date, String time, Double basePrice, Rating rating, Auditorium auditorium) {
        this.id = id;
        this.name = name;
        this.date = LocalDate.parse(date);
        this.time = LocalTime.parse(time);
        this.basePrice = basePrice;
        this.rating = rating;
        if (auditorium != null) {
            this.auditorium = auditorium;
            this.tickets = createTickets();
        }
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
        List<Ticket> ticketsList = new ArrayList<>();
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
