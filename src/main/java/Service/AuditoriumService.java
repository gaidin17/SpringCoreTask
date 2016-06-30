package service;

import dao.interfaces.AuditoriumDAO;
import domain.Auditorium;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class AuditoriumService {

    private AuditoriumDAO auditoriumDao;

    public void setAuditoriumDao(AuditoriumDAO auditoriumDao) {
        this.auditoriumDao = auditoriumDao;
    }

    public List<Auditorium> getAuditoriums() {
        return auditoriumDao.getAll();
    }

    public Auditorium getByName(String string) {
        return auditoriumDao.getByName(string);
    }

    public int getSeatsNumber(Auditorium auditorium) {
        return auditorium.getNumberOfSeats();
    }

    public List<Integer> getVipSeats(Auditorium auditorium) {
        return auditorium.getVipSeats();
    }
}
