package service;

import dao.interfaces.JobDAO;
import domain.Employee;
import domain.Job;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 7/4/2016.
 */
public class JobService {

    private JobDAO jobDao;

    public void setJobDao(JobDAO jobDao) {
        this.jobDao = jobDao;
    }

    public List<Job> getAll() {
        return jobDao.getAll();
    }

    public Job getById(int id) {
        return jobDao.getById(id);
    }

    public void register(Job job) {
        jobDao.create(job);
    }

    public void remove(Job job) {
        jobDao.remove(job);
    }

    public List<Job> getAvailableJobs() {
        return jobDao.getByEmployee(null);
    }

    public List<Job> getJobsByEmployeeId(Employee employee) {
        return jobDao.getByEmployee(employee);
    }

    public void update(Job job) {
        jobDao.update(job);
    }
}
