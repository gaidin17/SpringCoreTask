package controllers;

import domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.EmployeeService;

import java.util.List;
import java.util.Map;

/**
 * Created by Evgeny_Akulenko on 7/4/2016.
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/allEmployees", method = RequestMethod.GET)
    public ModelAndView getAllEmployees() {
        ModelAndView model = new ModelAndView();
        List<Employee> employees = employeeService.getAll();
        model.addObject("employees", employees);
        model.setViewName("work/allEmployees");
        return model;
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(@RequestParam Map<String, String> allRequestParams) {
        String name = allRequestParams.get("name");
        Employee employee = new Employee(name);
        employeeService.register(employee);
        return "redirect:/allEmployees";
    }
}
