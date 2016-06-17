package Service;

import DAO.Event;
import DAO.Ticket;
import DAO.User;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class BookingService {
    public double getTicketPrice(Event event, Date date, Time time, int seats, User user){return 0;}
    public void bookTicket(User user, Ticket ticket){}
    public List<Ticket> getTicketsForEvent(Event event,Date date){return null;}

}
