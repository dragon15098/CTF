package com.myjavablog.service.impl;

import com.myjavablog.model.Room;
import com.myjavablog.model.User;
import com.myjavablog.repository.RoomRepository;
import com.myjavablog.service.RoomService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    @Repository
    private final RoomRepository roomRepository;


    @Override
    public User saveRoom(Room room) {
        return null;
    }
}
