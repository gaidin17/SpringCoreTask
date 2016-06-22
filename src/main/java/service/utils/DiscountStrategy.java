package service.utils;

import domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class DiscountStrategy {
    private static final Logger logger = LoggerFactory.getLogger(DiscountStrategy.class);
    private int birthdayDiscount;
    private int everyTenDiscount;

    public int getBirthdayDiscount() {
        return birthdayDiscount;
    }

    public void setBirthdayDiscount(int birthdayDiscount) {
        this.birthdayDiscount = birthdayDiscount;
    }

    public int getEveryTenDiscount() {
        return everyTenDiscount;
    }

    public void setEveryTenDiscount(int everyTenDiscount) {
        this.everyTenDiscount = everyTenDiscount;
    }

    public Double getBirthdayDiscount(Event event) {
        if (event != null) {
            return event.getBasePrice() * birthdayDiscount / 100;
        } else {
            logger.warn("Warning: event is not found");
            return null;
        }
    }

    public Double getForEveryTenDiscount(Event event) {
        if (event != null) {
            return event.getBasePrice() * everyTenDiscount / 100;
        } else {
            logger.warn("Warning: event is not found");
            return null;
        }
    }

}

