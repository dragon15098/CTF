package com.myjavablog.service;

import com.myjavablog.model.UserRoom;

public interface UserRoomService {
    UserRoom addUserToRoom(int userId, int roomId);
}
