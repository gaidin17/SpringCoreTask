package service;

import dao.interfaces.EmployeeDAO;
import dao.interfaces.JobDAO;
import domain.Employee;
import domain.Job;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 7/4/2016.
 */
public class EmployeeService {

    private EmployeeDAO employeeDao;

    public void setEmployeeDao(EmployeeDAO employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void register(Employee employee) {
        employeeDao.create(employee);
    }

    public void remove(Employee employee) {
        employeeDao.remove(employee);
    }

    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    public Employee getById(int id) {
        return employeeDao.getById(id);
    }
}
