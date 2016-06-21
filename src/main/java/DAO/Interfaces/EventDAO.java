package DAO.Interfaces;

import Domain.Event;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/20/2016.
 */
public interface EventDAO {

    List<Event> getAll();

    Event getById(int id);

    void create(Event event);

    void remove(Event event);
}
