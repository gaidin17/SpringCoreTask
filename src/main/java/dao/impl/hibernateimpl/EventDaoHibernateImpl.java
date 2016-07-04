package dao.impl.hibernateimpl;

import dao.interfaces.EventDAO;
import domain.Event;
import org.springframework.transaction.annotation.Transactional;

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
        em.persist(event);
    }

    @Transactional
    @Override
    public void remove(Event event) {
        em.remove(event);
    }

    @Transactional
    @Override
    public void update(Event event) {
        em.merge(event);
    }
}
