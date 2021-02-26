package com.myjavablog.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.myjavablog.model.*;
import com.myjavablog.repository.MessageRepository;
import com.myjavablog.repository.RoomRepository;
import com.myjavablog.repository.UserRoomRepository;
import com.myjavablog.service.RoomService;
import com.myjavablog.service.UserRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final UserRoomService userRoomService;
    private final UserRoomRepository userRoomRepository;
    private final MessageRepository messageRepository;

    @Override
    public Room saveRoom(String roomName) {
        Room room = new Room();
        room.setRoomName(roomName);
        Integer userId = Helper.getUserId();
        if (userId != null) {
            room.setHostUserId(userId);
            room.setRoomType(0);
            room = roomRepository.save(room);
            if (room.getId() != null) {
                userRoomService.addUserToRoom(userId, room.getId());
            }
        }
        return room;
    }

    @Override
    public Room findById(Integer roomId) {
        if (checkUserInRoom(roomId)) {
            Room room = roomRepository.findById(roomId).orElse(null);
            if (room != null) {
                List<Message> messages = getMessages(roomId);
                if (room.getRoomType().equals(1)) { // room VIP
                    for (Message message : messages) {
                        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
                        List style = JSON.parseArray(message.getMessageOptionStr(), Object.class);
                        message.setMessageOption(style);
                    }
                }
                room.setMessages(messages);
            }
            return room;
        }
        return null;
    }

    private List<Message> getMessages(Integer roomId) {
        return messageRepository.getAllMessage(roomId);
    }

    @Override
    public List<Room> getRoomsUser() {
        List<Room> result = new ArrayList<>();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            Integer userId = ((User) principal).getId();
            result.addAll(roomRepository.findAllByUserId(userId));
        }
        return result;
    }

    private boolean checkUserInRoom(Integer roomId) {
        UserRoom userRoom = userRoomRepository.findByUserIdAndRoomId(Helper.getUserId(), roomId);
        return userRoom != null;
    }
}
