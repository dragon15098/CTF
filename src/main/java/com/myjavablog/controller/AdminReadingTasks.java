package com.myjavablog.controller;

import com.myjavablog.model.Room;
import com.myjavablog.repository.MessageRepository;
import com.myjavablog.repository.RoomRepository;
import com.myjavablog.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class AdminReadingTasks {
    @Autowired
    MessageRepository messageRepository;

    @Scheduled(fixedDelay = 5000, initialDelay = 1000)
    public void scheduleTaskWithFixedRate() {
        System.out.println("Admin reading message");
        messageRepository.getAllMessage(1); // ROOM SUPER VIP
        System.out.println("Stop reading message");

    }
}