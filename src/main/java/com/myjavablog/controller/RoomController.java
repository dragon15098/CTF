package com.myjavablog.controller;

import com.myjavablog.model.User;
import com.myjavablog.service.RoomService;
import com.myjavablog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public ModelAndView getRoom() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("room");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView createRoom(@RequestParam("roomName") String roomName) {
        ModelAndView modelAndView = new ModelAndView();
        if (roomName != null) {
            roomService.saveRoom(roomName);
        }
        modelAndView.addObject("message", "Create room success");
        modelAndView.setViewName("room");
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView getCreateRoomForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create-room");
        return modelAndView;
    }

}
