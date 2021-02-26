package com.myjavablog.controller;

import com.myjavablog.model.Helper;
import com.myjavablog.model.Room;
import com.myjavablog.model.User;
import com.myjavablog.service.MessageService;
import com.myjavablog.service.RoomService;
import com.myjavablog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private MessageService messageService;

    @GetMapping
    public ModelAndView getAllRoomUser() {
        ModelAndView modelAndView = new ModelAndView();
        List<Room> rooms = roomService.getRoomsUser();
        modelAndView.addObject("rooms", rooms);
        modelAndView.setViewName("room");
        return modelAndView;
    }

    @GetMapping(value = "/{roomId}")
    public ModelAndView getRoomDetail(@PathVariable Integer roomId) {
        ModelAndView modelAndView = new ModelAndView();
        Room room = roomService.findById(roomId);
        if (room == null) {
            modelAndView.setViewName("access-denied");
        }
        modelAndView.addObject("room", room);
        modelAndView.addObject("url", "/room/" + roomId + "/message");
        modelAndView.addObject("invitationId_url", "/invitation/" + roomId);
        modelAndView.addObject("userId", Helper.getUserId());
        modelAndView.setViewName("room-chat");
        return modelAndView;
    }

    @RequestMapping(value = "/{roomId}/message", method = RequestMethod.POST)
    public void sendMessage(HttpServletResponse httpServletResponse,
                            @RequestParam Map<String, String> map, @PathVariable Integer roomId) {
        messageService.saveMessage(map, roomId);
        httpServletResponse.setHeader("Location", "/room/" + roomId);
        httpServletResponse.setStatus(302);
    }

    @PostMapping(value = "/create")
    public ModelAndView createRoom(@RequestParam("roomName") String roomName) {
        ModelAndView modelAndView = new ModelAndView();
        if (roomName != null) {
            roomService.saveRoom(roomName);
        }
        modelAndView.addObject("message", "Create room success");
        modelAndView.setViewName("create-room");
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView getCreateRoomForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "");
        modelAndView.setViewName("create-room");
        return modelAndView;
    }

}
