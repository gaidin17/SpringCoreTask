package dao.impl.hibernateimpl;

import dao.interfaces.EventDAO;
import domain.Event;
import org.springframework.transaction.annotation.Transactional;
import utils.exceptions.DataBlockedException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 7/4/2016.
 */
public class EventDaoHibernateImpl implements EventDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Event> getAll() {
        return em.createQuery("from events", Event.class).getResultList();
    }

    @Override
    public Event getById(int id) {
        return em.find(Event.class, id);
    }

    @Transactional
    @Override
    public void create(Event event) {
        try {
            em.persist(event);
        } catch (Exception ex) {
            throw new DataBlockedException("This event is allready in database");
        }
    }

    @Transactional
    @Override
    public void remove(Event event) {
        Event eventForRemove = getById(event.getId());
        em.remove(eventForRemove);
    }

    @Transactional
    @Override
    public void update(Event event) {
        em.merge(event);
    }
}
