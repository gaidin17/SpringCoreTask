package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import utils.exceptions.EventCenterException;


/**
 * Created by Evgeny_Akulenko on 6/27/2016.
 */
@Controller
@ControllerAdvice
public class ExeptionController {
    private static final Logger logger = LoggerFactory.getLogger(ExeptionController.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        logger.warn("Exception handler executed");
        ModelAndView model = new ModelAndView();
        String message = ex.toString();
        System.out.println(message);
        model.addObject("message", message);
        model.setViewName("errorpages/exception");
        return model;
    }
}
