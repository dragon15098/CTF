package com.myjavablog.model;

import javax.persistence.*;

@Entity
@Table(name = "INVITE")
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INVITATION_ID")
    private Integer id;

    @Column(name = "ROOM_ID")
    private Integer roomId;

    @Column(name = "TO_USER_ID")
    private Integer toUserId;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "FROM_USER_ID")
    private Integer fromUserId;

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

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }
}
