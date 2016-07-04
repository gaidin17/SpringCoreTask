package dao.interfaces;

import domain.Employee;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 7/4/2016.
 */
public interface EmployeeDAO {

    Employee getById(int id);

    List<Employee> getAll();

    void create(Employee employee);

    void remove(Employee employee);

    void update(Employee employee);
}
