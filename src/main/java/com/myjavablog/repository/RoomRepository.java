package com.myjavablog.repository;

import com.myjavablog.model.Message;
import com.myjavablog.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findById(int id);
}
