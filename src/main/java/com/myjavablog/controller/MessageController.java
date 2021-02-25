package com.myjavablog.controller;

import com.alibaba.fastjson.parser.ParserConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class MessageController {

    @RequestMapping(value = "/read-message", method = RequestMethod.GET)
    public String registration() {
        //Serialization
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        // do query



        return "registration";
    }
}
