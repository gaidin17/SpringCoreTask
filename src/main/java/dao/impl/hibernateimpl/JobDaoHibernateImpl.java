package dao.impl.hibernateimpl;

import dao.interfaces.JobDAO;
import domain.Employee;
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
    public List<Job> getByEmployee(Employee employee) {
        if (employee == null) {
            return em.createQuery("from jobs j where j.employee is null", Job.class).getResultList();
        } else {
            return em.createQuery("from jobs j where j.employee = :employee", Job.class).setParameter("employee", employee).getResultList();
        }
    }

    @Override
    @Transactional
    public void create(Job job) {
        em.persist(job);
    }

    @Override
    @Transactional
    public void remove(Job job) {
        Job jobForRemove = getById(job.getId());
        em.remove(jobForRemove);
    }

    @Override
    @Transactional
    public void update(Job job) {
        em.merge(job);
    }
}
