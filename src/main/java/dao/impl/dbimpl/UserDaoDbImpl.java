package dao.impl.dbimpl;

import dao.interfaces.UserDAO;
import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        jdbcTemplate.update("INSERT INTO users (name, email, birthdate) VALUES (?,?,?)",
                user.getName(),
                user.getEmail(),
                user.getBirthDate().toString());
    }

    public void remove(User user) {
        jdbcTemplate.update("DELETE FROM users WHERE users.id = ?",
                user.getId());
    }

    public User getById(int id) {
        User user = null;
        try {
            user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE users.id = ?",
                    new Object[]{id},
                    new UserRowMapper());
        } catch (Exception ex) {
            logger.warn("Where is no one users with id = {}", id);
        }
        return user;
    }

    public List<User> getByName(String name) {
        List<User> users = new ArrayList<>();
        try {
            users = jdbcTemplate.query("SELECT * FROM users WHERE users.name = ?",
                    new Object[]{name},
                    new UserRowMapper());

        } catch (Exception ex) {
            logger.warn("Where is no one users with name = {}", name);
        }
        return users;
    }

    public User getByEmail(String email) {
        User user = null;
        try {
            user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE users.email = ?",
                    new Object[]{email},
                    new UserRowMapper());
        } catch (Exception ex) {
            logger.warn("Where is no one users with email = {}", email);
        }
        return user;
    }

    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM users",
                new UserRowMapper());
    }

    public void update(User user) {
        jdbcTemplate.update("UPDATE users SET name = ?, email = ?, birthDay = ? WHERE users.id = ?",
                user.getName(),
                user.getEmail(),
                user.getBirthDate().toString(),
                user.getId());
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
}


