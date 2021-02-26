package com.myjavablog.repository;

import com.myjavablog.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query(value = "SELECT m.* FROM ROOM r " +
            "JOIN ROOM_MESSAGE rm ON rm.ROOM_ID = r.ROOM_ID " +
            "JOIN MESSAGE m ON m.MESSAGE_ID = rm.MESSAGE_ID WHERE r.ROOM_ID = :roomId",
            nativeQuery = true)
    List<Message> getAllMessage(@Param("roomId") Integer roomId);
}
