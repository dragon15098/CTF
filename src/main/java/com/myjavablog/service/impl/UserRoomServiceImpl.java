package com.myjavablog.service.impl;

import com.myjavablog.model.UserRoom;
import com.myjavablog.repository.UserRoomRepository;
import com.myjavablog.service.UserRoomService;
import org.springframework.stereotype.Service;

@Service
public class UserRoomServiceImpl implements UserRoomService {

    private final UserRoomRepository userRoomRepository;

    public UserRoomServiceImpl(UserRoomRepository userRoomRepository) {
        this.userRoomRepository = userRoomRepository;
    }

    @Override
    public UserRoom addUserToRoom(int userId, int roomId) {
        UserRoom userRoom = new UserRoom(roomId, userId);
        return userRoomRepository.save(userRoom);
    }
}
