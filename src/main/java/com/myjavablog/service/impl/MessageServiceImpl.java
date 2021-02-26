package com.myjavablog.service.impl;

import com.myjavablog.model.*;
import com.myjavablog.repository.MessageRepository;
import com.myjavablog.repository.RoomMessageRepository;
import com.myjavablog.repository.RoomRepository;
import com.myjavablog.repository.UserRoomRepository;
import com.myjavablog.service.MessageService;
import com.myjavablog.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final RoomRepository roomRepository;
    private final UserRoomRepository userRoomRepository;
    private final RoomMessageRepository roomMessageRepository;

    @Override
    public Message saveMessage(Map<String, String> map, Integer roomId) {
        Message message = new Message();
        Room room = roomRepository.getOne(roomId);
        message.setMessage(map.get("message"));
        Integer userId = Helper.getUserId();
        if (userId != null && checkUserInRoom(roomId, userId)) {
            message.setUserId(userId);
            if (room.getRoomType() == 1) { // just VIP Room only
                StringBuilder data = new StringBuilder("[");
                for (String key : map.keySet()) { // save in string
                    if (!key.equals("roomId") && !key.equals("message")) {
                        data.append("{\"@type\":\"").append(key).append("\",\"value\":\"").append(map.get(key)).append("\"},");
                    }
                }
                int index = data.lastIndexOf(",");
                if (index != -1) {
                    data.deleteCharAt(index).append("]"); // remove last , then add ] close array
                }
                message.setMessageOptionStr(data.toString());
            }
            message = messageRepository.save(message);
            RoomMessage roomMessage = saveToRoomMessage(message.getId(), roomId);
            if (roomMessage.getId() != null) {
                return message;
            }
        }
        return null;
    }

    private RoomMessage saveToRoomMessage(Integer messageId, Integer roomId) {
        RoomMessage roomMessage = new RoomMessage(roomId, messageId);
        return roomMessageRepository.save(roomMessage);
    }

    private boolean checkUserInRoom(Integer roomId, Integer userId) {
        UserRoom userRoom = userRoomRepository.findByUserIdAndRoomId(userId, roomId);
        return userRoom != null;
    }
}
