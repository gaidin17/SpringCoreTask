package dao.impl.dbimpl;

import dao.interfaces.AuditoriumDAO;
import dao.interfaces.EventDAO;
import domain.Event;
import domain.enums.Rating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
        return jdbcTemplate.query("SELECT * FROM events",
                new EventRowMapper());
    }

    public Event getById(int id) {
        Event event = null;
        try {
            event = jdbcTemplate.queryForObject("SELECT * FROM events WHERE events.id = ?",
                    new Object[]{id},
                    new EventRowMapper());
        } catch (Exception ex) {
            logger.warn("Where is no one event with id = {}", id);
        }
        return event;
    }

    public void create(Event event) {
        jdbcTemplate.update("INSERT INTO events (name, date, time, baseprice, rating, auditoriumid ) VALUES (?,?,?,?,?,?)",
                event.getName(),
                event.getDate(),
                event.getTime(),
                event.getBasePrice(),
                event.getRating().toString(),
                event.getAuditorium().getId());
    }

    public void remove(Event event) {
        jdbcTemplate.update("DELETE FROM events WHERE events.id = ?",
                event.getId());
    }

    public void update(Event event) {
        jdbcTemplate.update("UPDATE users SET mame = ?, date = ?, time= ?, baseprice = ?, rating = ?, auditoriumid = ? WHERE users.id = ?",
                event.getName(),
                event.getDate(),
                event.getTime(),
                event.getBasePrice(),
                event.getRating().toString(),
                event.getAuditorium().getId());
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
