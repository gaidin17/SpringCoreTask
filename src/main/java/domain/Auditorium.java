package Domain;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/20/2016.
 */
public class Auditorium {
    private static int id = 0;
    private String name;
    private int numberOfSeats;
    private double modificatorForVip;
    private List<Integer> vipSeats;


    public Auditorium(String name, int numberOfSeats, double modificatorForVip, List<Integer> vipSeats) {
        id = id++;
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.modificatorForVip = modificatorForVip;
        this.vipSeats = vipSeats;
    }

    public int getId() {
        return id;
    }

    public Double getModificatorForVip() {
        return  this.modificatorForVip;
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
}
