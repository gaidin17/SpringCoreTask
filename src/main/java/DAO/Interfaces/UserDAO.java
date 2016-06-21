package DAO.Interfaces;

import Domain.User;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/20/2016.
 */
public interface UserDAO {

    List<User> getAllUsers();

    User getById(int id);

    List<User> getByName(String name);

    User getByEmail(String email);

    List<User> getAll();

    void create(User user);

    void remove(User user);
}
