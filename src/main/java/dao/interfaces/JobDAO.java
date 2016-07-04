package dao.interfaces;

import domain.Job;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 7/4/2016.
 */
public interface JobDAO {

    Job getById(int id);

    List<Job> getAll();

    void create(Job job);

    void remove(Job job);

    void update(Job job);
}
