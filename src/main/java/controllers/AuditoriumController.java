package controllers;

import domain.Auditorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.AuditoriumService;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 6/27/2016.
 */
@Controller
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;

    @RequestMapping(value = "/addEvent", method = RequestMethod.GET)
    public ModelAndView getAllAuditoriumsName() {
        ModelAndView model = new ModelAndView();
        List<Auditorium> auditoriums = auditoriumService.getAuditoriums();
        model.addObject("auditoriums", auditoriums);
        model.setViewName("/addEvent");
        return model;
    }

    @RequestMapping(value = "/auditoriumsByName/{name}/")
    public ModelAndView getAuditoriumsByName(@PathVariable("name") String name) {
        ModelAndView model = new ModelAndView();
        Auditorium auditorium = auditoriumService.getByName(name);
        model.addObject("auditorium", auditorium);
        model.setViewName("auditoriums/auditoriumsByName");
        return model;
    }

    @RequestMapping(value = "/allAuditoriums", method = RequestMethod.GET)
    public ModelAndView getAllAuditoriums() {
        ModelAndView modelAndView = getAllAuditoriumsName();
        modelAndView.setViewName("auditoriums/allAuditoriums");
        return modelAndView;
    }
}
