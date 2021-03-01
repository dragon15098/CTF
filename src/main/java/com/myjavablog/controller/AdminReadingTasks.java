package com.myjavablog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.myjavablog.model.Message;
import com.myjavablog.model.Room;
import com.myjavablog.repository.MessageRepository;
import com.myjavablog.repository.RoomRepository;
import com.myjavablog.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AdminReadingTasks {
    @Autowired
    MessageRepository messageRepository;

    @Scheduled(fixedDelay = 5000, initialDelay = 1000)
    public void scheduleTaskWithFixedRate() {
        System.out.println("Admin reading message");
        List<Message> messages = messageRepository.getAllMessage(1);// ROOM SUPER VIP
        for (Message message : messages) {
            ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
            List style = JSON.parseArray(message.getMessageOptionStr(), Object.class);
            message.setMessageOption(style);
            clearMessage(message);
        }

        System.out.println("Stop reading message");

    }

    private void clearMessage(Message message) {
        if (message.getId() != 1) {  //Not GOD Message
            messageRepository.delete(message);
        }
    }


}
