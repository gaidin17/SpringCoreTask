package dao.impl.dbimpl;

import dao.interfaces.UserDAO;
import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.exceptions.EventCenterDaoException;
import utils.exceptions.EventCenterException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class UserDaoDbImpl implements UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoDbImpl.class);
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(User user) {

        try {
            if (isUnique(user)) {
                jdbcTemplate.update("INSERT INTO users (name, email, birthdate) VALUES (?,?,?)",
                        user.getName(),
                        user.getEmail(),
                        user.getBirthDate().toString());
            } else {
                String message = "User with email =" + user.getEmail() + "is allready exist in data base";
                logger.warn(message);
                throw new EventCenterDaoException(message);
            }
        } catch (DataAccessException ex) {
            String message = "Unavalible to create user with email= " + user.getEmail();
            logger.error(message);
            throw new EventCenterDaoException(message);
        }

    }

    public void remove(User user) {
        try {
            jdbcTemplate.update("DELETE FROM users WHERE users.id = ?",
                    user.getId());
        } catch (DataAccessException ex) {
            String message = "Unavalible to remove user with email= " + user.getEmail();
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
    }

    public User getById(int id) {
        User user;
        try {
            user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE users.id = ?",
                    new Object[]{id},
                    new UserRowMapper());
        } catch (DataAccessException ex) {
            String message = "Unavalible to get user with id= " + id;
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
        return user;
    }

    public List<User> getByName(String name) {
        List<User> users;
        try {
            users = jdbcTemplate.query("SELECT * FROM users WHERE users.name = ?",
                    new Object[]{name},
                    new UserRowMapper());

        } catch (DataAccessException ex) {
            String message = "Unavalible to get user with name= " + name;
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
        return users;
    }

    public User getByEmail(String email) {
        User user;
        try {
            user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE users.email = ?",
                    new Object[]{email},
                    new UserRowMapper());
        } catch (DataAccessException ex) {
            String message = "Unavalible to get user with email= " + email;
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
        return user;
    }

    public List<User> getAll() {
        try {
            return jdbcTemplate.query("SELECT * FROM users",
                    new UserRowMapper());
        } catch (DataAccessException ex) {
            String message = "Unavalible to get all users";
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
    }

    public void update(User user) {
        try {
            jdbcTemplate.update("UPDATE users SET name = ?, email = ?, birthDay = ? WHERE users.id = ?",
                    user.getName(),
                    user.getEmail(),
                    user.getBirthDate().toString(),
                    user.getId());
        } catch (DataAccessException ex) {
            String message = "Unavalible to update user with email= " + user.getEmail();
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
    }

    private class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("birthdate"));
        }
    }

    private boolean isUnique(User user) {
        try {
            getByEmail(user.getEmail());
            return false;
        } catch (EventCenterDaoException ex) {
            return true;
        }
    }
}

