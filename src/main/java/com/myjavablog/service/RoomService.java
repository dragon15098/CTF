package com.myjavablog.service;

import com.myjavablog.model.Room;
import com.myjavablog.model.User;

public interface RoomService {
    Room saveRoom(String roomName);

    Room findById(Room room);
}
