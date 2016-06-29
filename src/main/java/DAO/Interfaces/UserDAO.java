package dao.interfaces;

import domain.User;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/20/2016.
 */
public interface UserDAO {

    User getById(int id);

    List<User> getByName(String name);

    User getByEmail(String email);

    List<User> getAll();

    void create(User user);

    void remove(User user);

    void update(User user);
}
