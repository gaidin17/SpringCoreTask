package Service;

import DAO.Interfaces.UserDAO;
import Domain.Ticket;
import Domain.User;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class UserService {
    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    private UserDAO userDao;

    public void register(User user) {
        userDao.create(user);
    }

    public void remove(User user) {
        userDao.remove(user);
    }

    public User getById(int id) {
        return userDao.getById(id);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User getUserByEmail(String email) {
        return userDao.getByEmail(email);
    }

    public List<User> getUsersByName(String name) {
        return userDao.getByName(name);
    }

    public List<Ticket> getBookedTickets(User user) {
        return user.getTickets();
    }
}
