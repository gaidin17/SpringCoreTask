package dao.impl;

import dao.interfaces.UserDAO;
import domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class UserDaoImpl implements UserDAO {
    private List<User> users;

    public UserDaoImpl(List<User> users) {
        this.users = users;
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public User getById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> getByName(String name) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getName().equals(name)) {
                result.add(user);
            }
        }
        return result;
    }

    public User getByEmail(String email) {
        for (User user : users) {
            if (user.getName().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAll() {
        return users;
    }

    public void create(User user) {
        users.add(user);
    }

    public void remove(User user) {
        users.remove(user);
    }

    public void update(User user) {
        throw new UnsupportedOperationException("This operation  is unsupported");
    }
}


