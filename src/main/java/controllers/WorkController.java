package controllers;

import domain.Employee;
import domain.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.EmployeeService;
import service.JobService;
import service.WorkService;

import java.util.List;
import java.util.Map;

/**
 * Created by Evgeny_Akulenko on 7/5/2016.
 */
@Controller
public class WorkController {
    @Autowired
    private JobService jobService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private WorkService workService;

    @RequestMapping(value = "/allAvailableJobs", method = RequestMethod.GET)
    public ModelAndView getAvailableJob(@RequestParam Map<String, String> allRequestParams) {
        ModelAndView model = new ModelAndView();
        List<Job> jobs = jobService.getAvailableJobs();
        List<Employee> employees = employeeService.getAll();
        model.addObject("jobs", jobs);
        model.addObject("employees", employees);
        model.setViewName("work/availableJobs");
        return model;
    }

    @RequestMapping(value = "/assignEmployee", method = RequestMethod.POST)
    public String assignEmployee(@RequestParam Map<String, String> allRequestParams) {
        int jobId = Integer.parseInt(allRequestParams.get("job"));
        int employeeId = Integer.parseInt(allRequestParams.get("employee"));
        workService.assignJobToEmployee(employeeService.getById(employeeId), jobService.getById(jobId));
        return "redirect:/employeeJobs/" + employeeId + "/";
    }

    @RequestMapping(value = "/employeeJobs/{empId}/", method = RequestMethod.GET)
    public ModelAndView getEmployeeJobs(@PathVariable("empId") String empId) {
        ModelAndView model = new ModelAndView();
        Employee employee = employeeService.getById(Integer.parseInt(empId));
        List<Job> jobs = employee.getJobs();
        model.addObject("employee", employee);
        model.addObject("jobs", jobs);
        model.setViewName("work/jobsOfEmployee");
        return model;
    }
}
