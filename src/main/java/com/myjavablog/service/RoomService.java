package com.myjavablog.service;

import com.myjavablog.model.Room;

import java.util.List;

public interface RoomService {
    Room saveRoom(String roomName);

    Room findById(Integer roomId);

    List<Room> getRoomsUser();

}
