package ua.lukianchykov.springmvc.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/calculator")
    public String helloPage(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "action", required = false) String action,
                            Model model){

        //System.out.println("Hello, " + name + " " + surname);
        double result = 0;
        model.addAttribute("message", "Numbers: " + a + ", " + b);
        model.addAttribute("action", "Action: " + action);
        if(action.equals("multiplication")){
            result = a * b;
        }
        else if(action.equals("addition")){
            result = a + b;
        }
        else if(action.equals("subtraction")){
            result = a - b;
        }
        else if(action.equals("division")){
            result = a / (double)b;
        }
        else{
            result = 0;
        }
        model.addAttribute("result", "Result: " + result);
        return "first/calculator";
    }

    @GetMapping("/hello")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              Model model){

        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
}
