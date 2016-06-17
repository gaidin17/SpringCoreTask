package Service;

import DAO.User;
import UTIL.DiscountStrategy;

import java.util.Date;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class DiscountService {
    public DiscountStrategy discountStrategy;
    public double getDiscount(User user, User event, Date date){return 0;}
}
