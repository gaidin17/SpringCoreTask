package service;


import dao.interfaces.EventDAO;
import domain.Auditorium;
import domain.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */

public class EventService {
    private EventDAO eventDao;

    public void setEventDao(EventDAO eventDao) {
        this.eventDao = eventDao;
    }

    public void create(Event event) {

        eventDao.create(event);
    }

    public void remove(Event event) {

        eventDao.remove(event);
    }

    public Event getByName(String name) {
        List<Event> events = getAll();
        for (Event event : events) {
            if (event.getName().equals(name)) {
                return event;
            }
        }
        return null;
    }

    public List<Event> getAll() {
        return eventDao.getAll();
    }

    public List<Event> getForDateRange(Date dateFrom, Date dateTo) {
        //TODO
        //OPTIONAL
        return null;
    }

    public List<Event> getNextEvents(Date dateTo) {
        //TODO
        //OPTIONAL
        return null;
    }

    public void assignAuditorium(Event event, Auditorium auditorium, LocalDate date, LocalTime time) {
        if (!eventDao.getAll().contains(event)) {
            eventDao.create(event);
        }
        event.setAuditorium(auditorium);
        event.setDate(date);
        event.setTime(time);
    }
}




