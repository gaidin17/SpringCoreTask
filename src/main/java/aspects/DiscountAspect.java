package aspects;

import domain.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


@Aspect
public class DiscountAspect {
    private static final Logger logger = LoggerFactory.getLogger(DiscountAspect.class);
    private Map<String, Integer> counter = new HashMap<>();
    private Map<String, Integer> counterBirthDayDiscoutForUser = new HashMap<>();
    private Map<String, Integer> counterEveryTenDiscountForUser = new HashMap<>();

    public void setCounter(Map<String, Integer> counter) {
        this.counter = counter;
    }

    public Map<String, Integer> getCounter() {
        return counter;
    }

    public void setCounterBirthDayDiscoutForUser(Map<String, Integer> counterBirthDayDiscoutForUser) {
        this.counterBirthDayDiscoutForUser = counterBirthDayDiscoutForUser;
    }

    public Map<String, Integer> getCounterBirthDayDiscoutForUser() {
        return counterBirthDayDiscoutForUser;
    }

    public void setCounterEveryTenDiscountForUser(Map<String, Integer> counterEveryTenDiscountForUser) {
        this.counterEveryTenDiscountForUser = counterEveryTenDiscountForUser;
    }

    public Map<String, Integer> getCounterEveryTenDiscountForUser() {
        return counterEveryTenDiscountForUser;
    }


    @Pointcut("execution(* service.utils.DiscountStrategy.getBirthdayDiscount(..))")
    private void birthDayDiscountMethod() {
    }

    @After("birthDayDiscountMethod() && args(user)")
    public void countBirthDayDiscountForUser(User user) {
        String userEmail = user.getEmail();
        if (!counterBirthDayDiscoutForUser.containsKey(userEmail)) {
            counterBirthDayDiscoutForUser.put(userEmail, 0);
        }
        counterBirthDayDiscoutForUser.put(userEmail, counterBirthDayDiscoutForUser.get(userEmail) + 1);
        logger.info("Counter service.utils.DiscountStrategy.getBirthdayDiscount(): done");
    }

    @Pointcut("execution(* service.utils.DiscountStrategy.getForEveryTenDiscount(..))")
    private void everyTenDiscountMethod() {
    }

    @After("everyTenDiscountMethod() && args(user)")
    public void countEveryTenDiscountForUser(User user) {
        String userEmail = user.getEmail();
        if (!counterEveryTenDiscountForUser.containsKey(userEmail)) {
            counterEveryTenDiscountForUser.put(userEmail, 0);
        }
        counterEveryTenDiscountForUser.put(userEmail, counterEveryTenDiscountForUser.get(userEmail) + 1);
        logger.info("Counter service.utils.DiscountStrategy.getForEveryTenDiscount(): done");
    }

    @Pointcut("execution(* service.DiscountService.getDiscount(..))")
    private void everyGetDiscountMethod() {
    }

    @After("everyGetDiscountMethod()")
    public void countEveryGeеDiscount(JoinPoint jp) {
        String className = jp.getTarget().getClass().getName();
        if (!counter.containsKey(className)) {
            counter.put(className, 0);
        }
        counter.put(className, counter.get(className) + 1);
        logger.info("Counter service.DiscountService.getDiscount(): done");
    }
}
