package com.ars;

import com.ars.model.Person;
import com.ars.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import java.util.Map;



@Controller
public class MainController extends HttpServlet{

    @Autowired
    private PersonService personService;

    @RequestMapping(value = {"/"})
    public ModelAndView launchSubmitForm(){
        ModelAndView model = new ModelAndView("mainpage", "person", new Person());
        return model;
    }


    @RequestMapping(value = "/submitData", method = RequestMethod.POST)
    public @ResponseBody Response addPerson(
            @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("age") Integer age){

        Response response = new Response();
        System.out.println("In controller method");
        System.out.println("First name - " + firstName + "\nage - " + age);
        if (personService.personVerification(firstName, lastName)) {
            personService.addNewPerson(firstName, lastName, age);
            response.setStatus("Success");
        }else{
            response.setStatus("Fail!");
        }

        return  response;
    }


    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    public ModelAndView listPerson(Map<String, Object> map){

        map.put("person", new Person());
        map.put("personList", personService.getPersonList());

        ModelAndView model = new ModelAndView("mainpage");

        return model;
    }

    @ExceptionHandler(Exception.class)
    public @ResponseBody String onException(Exception ex) {
        return ex.getMessage();
    }
}
