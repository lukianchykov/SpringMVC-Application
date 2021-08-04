package ua.lukianchykov.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lukianchykov.springmvc.dao.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    //Получим всех людей с DAO передадим данные на view
    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    //Получим 1 человека по его id из DAO и передадим его в view
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,
                       Model model){
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

}
