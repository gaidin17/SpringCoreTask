package domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/20/2016.
 */
public class Auditorium {
    private static final Logger logger = LoggerFactory.getLogger(Auditorium.class);
    private int id;
    private String name;
    private int numberOfSeats;
    private double modificatorForVip;
    private List<Integer> vipSeats;

    public Auditorium(int id, String name, int numberOfSeats, double modificatorForVip, String vipSeats) {
        this.id = id;
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.modificatorForVip = modificatorForVip;
        this.vipSeats = createVipSeatsList(vipSeats);
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
        return vipSeats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVipSeats(List<Integer> vipSeats) {
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
        for (Integer i : vipSeats) {
            builder.append("").append(i).append(",");
        }
        return builder.toString();
    }
}
