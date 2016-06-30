package dao.impl.dbimpl;

import dao.interfaces.AuditoriumDAO;
import dao.interfaces.EventDAO;
import domain.Event;
import domain.enums.Rating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.exceptions.EventCenterDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class EventDaoDbImpl implements EventDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoDbImpl.class);
    private AuditoriumDAO auditoriumDAO;
    private JdbcTemplate jdbcTemplate;

    public void setAuditoriumDAO(AuditoriumDAO auditoriumDAO) {
        this.auditoriumDAO = auditoriumDAO;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Event> getAll() {
        try {
            return jdbcTemplate.query("SELECT * FROM events",
                    new EventRowMapper());
        } catch (DataAccessException ex) {
            String message = "Unavalible to get all events";
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
    }

    public Event getById(int id) {
        Event event = null;
        try {
            event = jdbcTemplate.queryForObject("SELECT * FROM events WHERE events.id = ?",
                    new Object[]{id},
                    new EventRowMapper());
        } catch (DataAccessException ex) {
            String message = "Unavalible to get event with id = " + id;
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
        return event;
    }

    public void create(Event event) {
        try {
            jdbcTemplate.update("INSERT INTO events (name, date, time, baseprice, rating, auditoriumid ) VALUES (?,?,?,?,?,?)",
                    event.getName(),
                    event.getDate().toString(),
                    event.getTime().toString(),
                    event.getBasePrice(),
                    event.getRating().toString(),
                    event.getAuditorium().getId());
        } catch (DataAccessException ex) {
            String message = "Unavalible to create event with name = " + event.getName();
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
    }

    public void remove(Event event) {
        try {
            jdbcTemplate.update("DELETE FROM events WHERE events.id = ?",
                    event.getId());
        } catch (DataAccessException ex) {
            String message = "Unavalible to remove event with name = " + event.getName();
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
    }

    public void update(Event event) {
        try {
            jdbcTemplate.update("UPDATE users SET mame = ?, date = ?, time= ?, baseprice = ?, rating = ?, auditoriumid = ? WHERE users.id = ?",
                    event.getName(),
                    event.getDate(),
                    event.getTime(),
                    event.getBasePrice(),
                    event.getRating().toString(),
                    event.getAuditorium().getId());
        } catch (DataAccessException ex) {
            String message = "Unavalible to update event with name = " + event.getName();
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
    }

    private class EventRowMapper implements RowMapper<Event> {
        @Override
        public Event mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Event(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("date"),
                    resultSet.getString("time"),
                    resultSet.getDouble("basePrice"),
                    Rating.valueOf(resultSet.getString("rating")),
                    auditoriumDAO.getById(resultSet.getInt("auditoriumid")));
        }
    }
}
