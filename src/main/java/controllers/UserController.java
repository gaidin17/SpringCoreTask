package controllers;

import domain.Ticket;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import service.UserService;

import java.util.List;
import java.util.Map;

/**
 * Created by Evgeny_Akulenko on 6/24/2016.
 */
@Controller
public class UserController {
    @Autowired
    private View pdfTicketView;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
        ModelAndView model = new ModelAndView();
        List<User> users = userService.getAll();
        model.addObject("users", users);
        model.setViewName("users/allUsers");
        return model;
    }

    @RequestMapping(value = "/usersByEmail/{email}/", method = RequestMethod.GET)
    public ModelAndView getUsersByEmail(@PathVariable("email") String email) {
        ModelAndView model = new ModelAndView();
        User user = userService.getUserByEmail(email);
        model.addObject("user", user);
        model.setViewName("users/usersByEmail");
        return model;
    }

    @RequestMapping(value = "/bookedTickets/{userId}/", method = RequestMethod.GET)
    public ModelAndView getBookedTickets(@PathVariable("userId") String userId) {
        ModelAndView model = new ModelAndView();
        User user = userService.getUserByEmail(userId);
        List<Ticket> tickets = userService.getBookedTickets(user);
        model.addObject("user", user);
        model.addObject("tickets", tickets);
        model.addObject("tickets", tickets);
        model.setViewName("users/bookedTickets");
        return model;
    }

    @RequestMapping(value = "/pdfBookedTickets/{userId}/", method = RequestMethod.GET, headers = "accept=application/pdf")
    public ModelAndView getPdfBookedTickets(@PathVariable("userId") String userId) {
        ModelAndView model = new ModelAndView();
        User user = userService.getUserByEmail(userId);
        List<Ticket> tickets = userService.getBookedTickets(user);
        model.addObject("user", user);
        model.addObject("tickets", tickets);
        model.setView(pdfTicketView);
        return model;
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestParam Map<String, String> allRequestParams) {
        String name = allRequestParams.get("name");
        String email = allRequestParams.get("email");
        String date = allRequestParams.get("year") + "-" +
                allRequestParams.get("month") + "-" +
                allRequestParams.get("day");
        User user = new User(0, name, email, date);
        userService.register(user);
        return "redirect:/usersByEmail/" + email + "/";
    }
}
