package dao.impl.hibernateimpl;

import dao.interfaces.EmployeeDAO;
import domain.Auditorium;
import domain.Employee;
import domain.Job;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 7/4/2016.
 */
public class EmployeeDaoHibernateImpl implements EmployeeDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Employee getById(int id) {
        return em.find(Employee.class, id);
    }

    @Override
    public List<Employee> getAll() {
        return em.createQuery("from employees", Employee.class).getResultList();
    }

    @Override
    @Transactional
    public void create(Employee employee) {
        em.persist(employee);
    }

    @Override
    @Transactional
    public void remove(Employee employee) {
        em.remove(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        em.merge(employee);
    }
}
