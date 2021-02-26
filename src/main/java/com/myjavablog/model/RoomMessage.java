package com.myjavablog.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ROOM_MESSAGE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "USER_ROOM_ID")
    public Integer id;

    @Column(name = "ROOM_ID")
    public Integer roomId;

    @Column(name = "MESSAGE_ID")
    private Integer messageId;

    public RoomMessage(Integer roomId, Integer messageId) {
        this.roomId = roomId;
        this.messageId = messageId;
    }
}
