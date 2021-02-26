package com.myjavablog.repository;

import com.myjavablog.model.Message;
import com.myjavablog.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findById(int id);

    @Query(
            value = "SELECT r.* FROM ROOM r " +
                    "JOIN USER_ROOM ur ON ur.ROOM_ID = r.ROOM_ID " +
                    "JOIN USER u ON u.USER_ID = ur.USER_ID WHERE u.USER_ID = :userId",
            nativeQuery = true)
    List<Room> findAllByUserId(@Param("userId") Integer userId);

}
