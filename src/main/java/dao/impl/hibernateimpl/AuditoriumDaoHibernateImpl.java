package dao.impl.hibernateimpl;

import dao.interfaces.AuditoriumDAO;
import domain.Auditorium;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 7/4/2016.
 */
public class AuditoriumDaoHibernateImpl implements AuditoriumDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Auditorium getById(int id) {
        return em.find(Auditorium.class, id);
    }

    @Override
    public void create(Auditorium auditorium) {
        em.persist(auditorium);
    }

    @Override
    public void update(Auditorium auditorium) {
        em.merge(auditorium);
    }

    @Override
    public void remove(Auditorium auditorium) {
        em.remove(auditorium);
    }

    @Override
    public Auditorium getByName(String name) {
        return em.createQuery("from auditoriums a where a.name = :name", Auditorium.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public List<Auditorium> getAll() {
        return em.createQuery("from auditoriums", Auditorium.class).getResultList();
    }
}
