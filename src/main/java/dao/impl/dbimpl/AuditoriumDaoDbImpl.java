package dao.impl.dbimpl;

import dao.interfaces.AuditoriumDAO;
import domain.Auditorium;
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
 * Created by Evgeny_Akulenko on 6/22/2016.
 */
public class AuditoriumDaoDbImpl implements AuditoriumDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoDbImpl.class);
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Auditorium getById(int id) {
        Auditorium auditorium;
        try {
            auditorium = jdbcTemplate.queryForObject("SELECT * FROM auditoriums WHERE auditoriums.id = ?",
                    new Object[]{id},
                    new AuditoriumRowMapper());
        } catch (DataAccessException ex) {
            String message = "Where is no one auditorium with id = " + id;
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
        return auditorium;
    }

    public void create(Auditorium auditorium) {
        try {
            jdbcTemplate.update("INSERT INTO auditoriums (name, seats, modificatorforvip, vipseats ) VALUES (?,?,?,?)",
                    auditorium.getName(),
                    auditorium.getNumberOfSeats(),
                    auditorium.getModificatorForVip(),
                    auditorium.getVipSeats());
        } catch (DataAccessException ex) {
            String message = "Unavalible to create auditorium with name = " + auditorium.getName();
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
    }

    @Override
    public void update(Auditorium auditorium) {
        try {
            jdbcTemplate.update("UPDATE auditoriums  SET mame = ?, seats = ?, modificatorforvip= ?, vipseats = ? WHERE auditoriums.id = ?",
                    auditorium.getName(),
                    auditorium.getNumberOfSeats(),
                    auditorium.getModificatorForVip(),
                    auditorium.getVipSeats(),
                    auditorium.getId());
        } catch (DataAccessException ex) {
            String message = "Unavalible to update auditorium with name = " + auditorium.getName();
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
    }

    public void remove(Auditorium auditorium) {
        try {
            jdbcTemplate.update("DELETE FROM auditoriums WHERE auditoriums.id = ?",
                    auditorium.getId());
        } catch (DataAccessException ex) {
            String message = "Unavalible to remove auditorium with name = " + auditorium.getName();
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
    }

    public Auditorium getByName(String name) {
        Auditorium auditorium;
        try {
            auditorium = jdbcTemplate.queryForObject("SELECT * FROM auditoriums WHERE auditoriums.name = ?",
                    new Object[]{name},
                    new AuditoriumRowMapper());
        } catch (DataAccessException ex) {
            String message = "Unavalible to get auditorium with name = " + name;
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
        return auditorium;
    }

    public List<Auditorium> getAll() {
        try {
            return jdbcTemplate.query("SELECT * FROM auditoriums",
                    new AuditoriumRowMapper());
        } catch (DataAccessException ex) {
            String message = "Unavalible to get all auditoriums";
            logger.error(message);
            throw new EventCenterDaoException(message);
        }
    }

    private class AuditoriumRowMapper implements RowMapper<Auditorium> {
        @Override
        public Auditorium mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Auditorium(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("seats"),
                    resultSet.getDouble("modificatorforvip"),
                    resultSet.getString("vipseats"));
        }
    }
}
