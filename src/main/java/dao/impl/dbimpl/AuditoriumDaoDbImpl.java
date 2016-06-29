package dao.impl.dbimpl;

import dao.interfaces.AuditoriumDAO;
import domain.Auditorium;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
        Auditorium auditorium = null;
        try {
            auditorium = jdbcTemplate.queryForObject("SELECT * FROM auditoriums WHERE auditoriums.id = ?",
                    new Object[]{id},
                    new AuditoriumRowMapper());
        } catch (Exception ex) {
            logger.warn("Where is no one auditorium with id = {}", id);
        }
        return auditorium;
    }

    public void create(Auditorium auditorium) {
        jdbcTemplate.update("INSERT INTO auditoriums (name, seats, modificatorforvip, vipseats ) VALUES (?,?,?,?)",
                auditorium.getName(),
                auditorium.getNumberOfSeats(),
                auditorium.getModificatorForVip(),
                auditorium.getVipSeats());
    }

    @Override
    public void update(Auditorium auditorium) {
        jdbcTemplate.update("UPDATE auditoriums  SET mame = ?, seats = ?, modificatorforvip= ?, vipseats = ? WHERE auditoriums.id = ?",
                auditorium.getName(),
                auditorium.getNumberOfSeats(),
                auditorium.getModificatorForVip(),
                auditorium.getVipSeats(),
                auditorium.getId());
    }

    public void remove(Auditorium auditorium) {
        jdbcTemplate.update("DELETE FROM auditoriums WHERE auditoriums.id = ?",
                auditorium.getId());
    }

    public Auditorium getByName(String name) {
        Auditorium auditorium = null;
        try {
            auditorium = jdbcTemplate.queryForObject("SELECT * FROM auditoriums WHERE auditoriums.name = ?",
                    new Object[]{name},
                    new AuditoriumRowMapper());
        } catch (Exception ex) {
            logger.warn("Where is no one auditorium with name = {}", name);
        }
        return auditorium;
    }

    public List<Auditorium> getAll() {
        return jdbcTemplate.query("SELECT * FROM auditoriums",
                new AuditoriumRowMapper());
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
