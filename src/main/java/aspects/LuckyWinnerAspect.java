package aspects;

import domain.Ticket;
import domain.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LuckyWinnerAspect {
    private static final Logger logger = LoggerFactory.getLogger(DiscountAspect.class);

    @Pointcut("execution(* service.BookingService.bookTicket(..))")
    private void everyBookTicket() {
    }

    @Before("everyBookTicket() && args(user, ticket)")
    public void setTicketPriceToZero(User user, Ticket ticket) {
        if ((int) (Math.random()*1000) == 1) {
            ticket.setPrice(0);
            logger.info("User: {} is lucky! Price of ticket with id: {} is 0 now!" ,user.getName(), ticket.getId());
        }
    }
}
