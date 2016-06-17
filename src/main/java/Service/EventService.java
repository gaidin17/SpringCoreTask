package Service;

import DAO.Auditorium;
import DAO.Event;
import UTIL.Rating;

import java.util.Date;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class EventService {
    public Event create(String name, Rating rating, Date date, double price){return null;}
    public void remove() {}
    public Event getByName(String name){return null;}
    public List<Event> getAll(){return null;}
    public List<Event> getForDateRange(Date dateFrom, Date dateTo){return null;}
    public List<Event> getNextEvents(Date dateTo){return null;}
    public void assignAuditorium(Event event, Auditorium auditorium, Date date){}

}
