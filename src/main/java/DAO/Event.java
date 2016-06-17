package DAO;

import UTIL.Rating;

import java.util.Date;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class Event {
    private final String name;
    private final Rating rating;
    private final Date date;
    private final double price;

    public String getName() {
        return name;
    }

    public Rating getRating() {
        return rating;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public Event(String name, Rating rating, Date date, double price) {
        this.name = name;
        this.rating = rating;
        this.date = date;

        this.price = price;
    }
}
