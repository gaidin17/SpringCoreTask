package Domain;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/20/2016.
 */
public class User {
    private static int id = 0;
    private String name;
    private String email;
    private LocalDate birthDate;
    private List<Ticket> tickets;

    public User(String name, String email, String birthDate) {
        id = id++;
        this.name = name;
        this.email = email;
        this.birthDate = LocalDate.parse(birthDate);
    }

    public LocalDate getBirthDate() {
        return birthDate;
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

}
