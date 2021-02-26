package com.myjavablog.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER_ROOM")

public class UserRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "USER_ROOM_ID")
    public Integer id;

    @Column(name = "ROOM_ID")
    public Integer roomId;

    @Column(name = "USER_ID")
    private Integer userId;

    public UserRoom() {
    }

    public UserRoom(Integer roomId, Integer userId) {
        this.roomId = roomId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

