package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @RequestMapping(method = RequestMethod.GET)
    public String getRequest() {
        return "register";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String postRequest() {
        System.out.println("Do something");
        return "login";
    }


}