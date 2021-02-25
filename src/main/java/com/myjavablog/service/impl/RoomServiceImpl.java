package com.myjavablog.service.impl;

import com.myjavablog.model.Room;
import com.myjavablog.model.User;
import com.myjavablog.repository.RoomRepository;
import com.myjavablog.service.RoomService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room saveRoom(String roomName) {
        Room room = new Room();
        room.setRoomName(roomName);
        return roomRepository.save(room);
    }

    @Override
    public Room findById(Room room) {
        return roomRepository.findById(room.getId());
    }

}
