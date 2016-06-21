package Service;

import Service.ServiseUtils.DiscountStrategy;
import Domain.Event;
import Domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class DiscountService {
    private static final Logger logger = LoggerFactory.getLogger(DiscountService.class);
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public Double getDiscount(User user, Event event, LocalDate date) {
        if (user != null && event != null && date != null) {
            double basePrice = event.getBasePrice();
            double discount = 0d;
            int everyTenCount = user.getTickets().size() / 10;
            if (everyTenCount / 10 >= 1) {
                discount += everyTenCount * discountStrategy.getForEveryTenDiscount(event);
            }

            if (user.getBirthDate().getDayOfMonth() == date.getDayOfMonth() &&
                    user.getBirthDate().getMonthValue() == date.getMonthValue()) {
                discount += user.getTickets().size() * discountStrategy.getBirthdayDiscount(event);
            }
            return discount;
        } else {
            logger.warn("Warning: one or any @param is null");
            return null;
        }
    }
}