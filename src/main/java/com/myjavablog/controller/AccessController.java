package com.myjavablog.controller;

import com.myjavablog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccessController {

    @RequestMapping(value="/access-denied", method = RequestMethod.GET)
    public ModelAndView accessDenied(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("access-denied");
        return modelAndView;
    }
}
