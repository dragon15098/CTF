package com.myjavablog.controller;

import com.myjavablog.model.Helper;
import com.myjavablog.model.Invitation;
import com.myjavablog.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/invitation")
public class InvitationController {

    @Autowired
    InvitationService invitationService;

    @GetMapping(value = "/")
    public ModelAndView getInvitationId() {
        ModelAndView modelAndView = new ModelAndView();
        List<Invitation> invitations = invitationService.getInvitationIdsByUserId(Helper.getUserId());
        modelAndView.addObject("invitations", invitations);
        modelAndView.setViewName("invitation");
        return modelAndView;
    }

    @PostMapping(value = "/{roomId}")
    public void createInvitation(HttpServletResponse httpServletResponse,
                             @RequestParam("fromUserId") Integer fromUserId,
                             @RequestParam("toEmail") String toEmail,
                             @PathVariable Integer roomId) {
        invitationService.createInvitation(roomId, fromUserId, toEmail);
        httpServletResponse.setHeader("Location", "/room/" + roomId);
        httpServletResponse.setStatus(302);
    }


    @PostMapping(value = "/accept/{invitationId}")
    public void acceptInvitation(HttpServletResponse httpServletResponse, @PathVariable Integer invitationId) {
        invitationService.acceptInvitation(invitationId);
        httpServletResponse.setHeader("Location", "/room");
        httpServletResponse.setStatus(302);
    }
}
