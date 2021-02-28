package com.myjavablog.model;


import javax.persistence.*;

@Entity
@Table(name = "ROOM_MESSAGE")
public class RoomMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_MESSAGE_ID")
    public Integer id;

    @Column(name = "ROOM_ID")
    public Integer roomId;

    @Column(name = "MESSAGE_ID")
    private Integer messageId;

    public RoomMessage() {
    }

    public RoomMessage(Integer id) {
        this.id = id;
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

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public RoomMessage(Integer roomId, Integer messageId) {
        this.roomId = roomId;
        this.messageId = messageId;
    }
}
