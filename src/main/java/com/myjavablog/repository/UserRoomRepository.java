package com.myjavablog.repository;

import com.myjavablog.model.UserRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoomRepository extends JpaRepository<UserRoom, Integer> {
    UserRoom findByUserIdAndRoomId(Integer userId, Integer roomId);
}
