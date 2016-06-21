package DAO.Impl;

import DAO.Interfaces.EventDAO;
import Domain.Event;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class EventDaoImpl implements EventDAO {
    private List<Event> events;

    public EventDaoImpl(List<Event> events) {
        this.events = events;
    }

    public List<Event> getAll() {
        return events;
    }

    public Event getById(int id) {
        for (Event event : events) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }

    public void create(Event event) {
        events.add(event);
    }

    public void remove(Event event) {
        events.remove(event);
    }
}
