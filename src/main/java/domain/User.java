package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/20/2016.
 */
public class User {
    private int id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private List<Ticket> tickets;
    public User() {

    }
    public User(int id, String name, String email, String birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = LocalDate.parse(birthDate);
        this.tickets = new ArrayList<>();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID: ").append(id).append("\n");
        builder.append("Name: ").append(name).append("\n");
        builder.append("Email: ").append(email).append("\n");
        builder.append("Birthdate: ").append(birthDate).append("\n");
        builder.append("Ticket. seats:");
        for (Ticket ticket : tickets) {
            builder.append("").append(ticket.getSeat()).append(",");
        }
        return builder.toString();
    }
}
