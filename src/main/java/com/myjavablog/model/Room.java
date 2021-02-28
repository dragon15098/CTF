package com.myjavablog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID")
    private Integer id;

    @Column(name = "ROOM_NAME")
    private String roomName;

    @Column(name = "HOST_USER_ID")
    private Integer hostUserId;

    // Room Vip = 1, Normal = 0
    @Column(name = "TYPE")
    private Integer roomType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getHostUserId() {
        return hostUserId;
    }

    public void setHostUserId(Integer hostUserId) {
        this.hostUserId = hostUserId;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Transient
    private List<Message> messages;
}
