package dao.impl.hibernateimpl;

import dao.interfaces.JobDAO;
import domain.Job;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 7/4/2016.
 */
public class JobDaoHibernateImpl implements JobDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Job getById(int id) {
        return em.find(Job.class, id);
    }

    @Override
    public List<Job> getAll() {
        return em.createQuery("from jobs", Job.class).getResultList();
    }

    @Override
    @Transactional
    public void create(Job job) {
        em.persist(job);
    }

    @Override
    @Transactional
    public void remove(Job job) {
        em.remove(job);
    }

    @Override
    @Transactional
    public void update(Job job) {
        em.merge(job);
    }
}
