package DAO;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class Auditorium {
    private final String name;
    private final int numberOfSeats;
    private final List<Integer> vipSeats;

    public Auditorium(String name, int numberOfSeats, List<Integer> vipSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.vipSeats = vipSeats;
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
}
