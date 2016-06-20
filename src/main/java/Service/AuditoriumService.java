package Service;

import DAO.Interfaces.AuditoriumDAO;
import Domain.Auditorium;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/17/2016.
 */
public class AuditoriumService {
    private static final Logger logger = LoggerFactory.getLogger(AuditoriumService.class);
    private AuditoriumDAO auditoriumDAO;

    public List<Auditorium> getAuditoriums() {
        return auditoriumDAO.getAll();
    }

    public int getSeatsNumber(Auditorium auditorium) {
        return auditorium.getNumberOfSeats();
    }

    public List<Integer> getVipSeats(Auditorium auditorium) {
        return auditorium.getVipSeats();
    }
}
