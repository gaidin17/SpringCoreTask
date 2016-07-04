package service;

import domain.Employee;
import domain.Job;
import org.springframework.beans.factory.annotation.Autowired;
import utils.exceptions.DataBlockedException;

/**
 * Created by Evgeny_Akulenko on 7/4/2016.
 */
public class WorkService {
    private JobService jobService;

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    public void assignJobToEmployee(Employee employee, Job job) {
        Job jobForEmployee = jobService.getById(job.getId());
        if (jobForEmployee.getEmployee() == null) {
            jobForEmployee.setEmployee(employee);
        } else {
            throw new DataBlockedException("This job is allready assigned to employee");
        }
        jobService.update(jobForEmployee);
    }
}
