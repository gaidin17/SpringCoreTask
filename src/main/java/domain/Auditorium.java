package domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/20/2016.
 */
@Entity(name = "auditoriums")
public class Auditorium {

    @Transient
    private static final Logger logger = LoggerFactory.getLogger(Auditorium.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @Column(name = "seats")
    private int numberOfSeats;

    @Column(name = "modificatorforvip")
    private double modificatorForVip;

    @Column(name = "vipseats")
    private String vipSeats;

    @OneToMany(targetEntity = Event.class, mappedBy = "auditorium")
    private List<Event> events;

    public Auditorium() {

    }

    public Auditorium(int id, String name, int numberOfSeats, double modificatorForVip, String vipSeats) {
        this.id = id;
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.modificatorForVip = modificatorForVip;
        this.vipSeats = vipSeats;
    }

    private List<Integer> createVipSeatsList(String string) {
        String[] stringSeats = string.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s : stringSeats) {
            try {
                list.add(Integer.parseInt(s));
            } catch (NumberFormatException ex) {
                logger.error("wrong @param: ", ex);
            }
        }
        return list;
    }

    public int getId() {
        return id;
    }

    public Double getModificatorForVip() {
        return this.modificatorForVip;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public List<Integer> getVipSeats() {
        return createVipSeatsList(vipSeats);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVipSeats(String vipSeats) {
        this.vipSeats = vipSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID: ").append(id).append("\n");
        builder.append("Name: ").append(name).append("\n");
        builder.append("Number of seats: ").append(numberOfSeats).append("\n");
        builder.append("Vip seats:");
        for (Integer i : getVipSeats()) {
            builder.append("").append(i).append(",");
        }
        return builder.toString();
    }
}
