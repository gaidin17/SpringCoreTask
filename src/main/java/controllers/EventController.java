package controllers;

/**
 * Created by Evgeny_Akulenko on 6/27/2016.
 */

import domain.Auditorium;
import domain.Event;
import domain.enums.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import service.AuditoriumService;
import service.EventService;

import java.util.List;
import java.util.Map;

/**
 * Created by Evgeny_Akulenko on 6/24/2016.
 */
@Controller
public class EventController {
    @Autowired
    private View pdfEventView;

    @Autowired
    private EventService eventService;

    @Autowired
    private AuditoriumService auditoriumService;

    @RequestMapping(value = "/allEvents", method = RequestMethod.GET)
    public ModelAndView getAllEvents() {
        ModelAndView model = new ModelAndView();
        List<Event> events = eventService.getAll();
        model.addObject("events", events);
        model.setViewName("events/allEvents");
        return model;
    }

    @RequestMapping(value = "/eventsByName/{name}/", method = RequestMethod.GET)
    public ModelAndView getEventByName(@PathVariable("name") String name) {
        ModelAndView model = new ModelAndView();
        Event event = eventService.getByName(name);
        model.addObject("event", event);
        model.setViewName("events/eventsByName");
        return model;
    }

    @RequestMapping(value = "/pdfEventsByName/{name}/", method = RequestMethod.GET, headers = "accept=application/pdf")
    public ModelAndView getPdfEventByName(@PathVariable("name") String name) {
        ModelAndView model = new ModelAndView();
        Event event = eventService.getByName(name);
        model.addObject("event", event);
        model.setView(pdfEventView);
        return model;
    }


    @RequestMapping(value = "/addNewEvent", method = RequestMethod.POST)
    public String addUser(@RequestParam Map<String, String> allRequestParams) {
        String name = allRequestParams.get("name");
        String date = allRequestParams.get("year") + "-" +
                allRequestParams.get("month") + "-" +
                allRequestParams.get("day");
        String time = allRequestParams.get("hour") + ":" +
                allRequestParams.get("minutes");
        Double basePrice = Double.parseDouble(allRequestParams.get("basePrice"));
        Rating rating = Rating.valueOf(allRequestParams.get("rating"));
        Auditorium auditorium = auditoriumService.getByName(allRequestParams.get("auditorium"));
        Event event = new Event(0, name, date, time, basePrice, rating, auditorium);
        eventService.create(event);
        return "redirect:/eventsByName/" + name + "/";
    }
}

