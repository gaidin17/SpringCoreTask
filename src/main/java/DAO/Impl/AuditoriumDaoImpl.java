package DAO.Impl;

import DAO.Interfaces.AuditoriumDAO;
import Domain.Auditorium;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class AuditoriumDaoImpl implements AuditoriumDAO {
    private final static Logger logger = LoggerFactory.getLogger(AuditoriumDaoImpl.class);
    private List<Auditorium> auditoriums;

    public AuditoriumDaoImpl(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    public Auditorium getById(int id) {
        for (Auditorium auditorium : auditoriums) {
            if (auditorium.getId() == id) {
                return auditorium;
            }
        }
        logger.warn("Warning: where's no auditoriums with id = {}", id);
        return null;
    }

    public void create(Auditorium auditorium) {
        if (auditorium != null) {
            auditoriums.add(auditorium);
        } else {
            logger.warn("Warning: @param is null");
        }
    }

    public void remove(Auditorium auditorium) {
        if (auditoriums.contains(auditorium) && auditorium != null) {
            auditoriums.remove(auditorium);
        } else {
            logger.warn("Warning: @param is null or not contains in list");
        }
    }

    public Auditorium getByName(String name) {
        for (Auditorium auditorium : auditoriums) {
            if (auditorium.getName().equals(name)) {
                return auditorium;
            }
        }
        logger.warn("Warning: where's no auditoriums with name = {}", name);
        return null;
    }

    public List<Auditorium> getAll() {
        return auditoriums;
    }
}
