package com.myjavablog.repository;

import com.myjavablog.model.RoomMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomMessageRepository extends JpaRepository<RoomMessage, Integer> {
}
