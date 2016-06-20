package DAO.Interfaces;

import Domain.Auditorium;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/20/2016.
 */
public interface AuditoriumDAO {

        Auditorium getById(int id);

        void create(Auditorium auditorium);

        void remove(Auditorium auditorium);

        void update(Auditorium auditorium);

        Auditorium getByName(String name);

        List<Auditorium> getAll();
}
