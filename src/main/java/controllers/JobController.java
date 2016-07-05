package controllers;

import domain.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.JobService;
import utils.exceptions.DataBlockedException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Evgeny_Akulenko on 7/4/2016.
 */
@Controller
public class JobController {
    @Autowired
    private JobService jobService;

    @RequestMapping(value = "/allJobs", method = RequestMethod.GET)
    public ModelAndView getAllJobs() {
        ModelAndView model = new ModelAndView();
        List<Job> jobs = jobService.getAll();
        model.addObject("jobs", jobs);
        model.setViewName("work/allJobs");
        return model;
    }

    @RequestMapping(value = "/addJob", method = RequestMethod.POST)
    public String addJob(@RequestParam Map<String, String> allRequestParams) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        String date = allRequestParams.get("day") + "." +
                allRequestParams.get("month") + "." +
                allRequestParams.get("year");
        Date jobDate;
        try {
            jobDate = format.parse(date);
        } catch (ParseException ex) {
            throw new DataBlockedException("Date format is wrong");
        }
        String description = allRequestParams.get("description");
        Job job = new Job(jobDate, description);
        jobService.register(job);
        return "redirect:/allJobs";
    }
}
