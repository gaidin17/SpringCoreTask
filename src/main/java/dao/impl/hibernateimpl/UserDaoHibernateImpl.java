package dao.impl.hibernateimpl;

import dao.interfaces.UserDAO;
import domain.User;
import org.springframework.transaction.annotation.Transactional;
import utils.exceptions.DataBlockedException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 7/4/2016.
 */
public class UserDaoHibernateImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User getById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getByName(String name) {
        return em.createQuery("from users u where u.name = :name", User.class).setParameter("name", name).getResultList();
    }

    @Override
    public User getByEmail(String email) {
        return em.createQuery("Select u FROM users u WHERE u.email = :email", User.class).setParameter("email", email).getSingleResult();
    }

    @Override
    public List<User> getAll() {
        return em.createQuery("from users", User.class).getResultList();
    }


    @Transactional
    @Override
    public void create(User user) {
        try {
            em.persist(user);
        } catch (Exception ex) {
            throw new DataBlockedException("This user is allready in database");
        }
    }

    @Transactional
    @Override
    public void remove(User user) {
        User userForRemove = getById(user.getId());
        em.remove(userForRemove);
    }

    @Transactional
    @Override
    public void update(User user) {
        em.merge(user);

    }
}
