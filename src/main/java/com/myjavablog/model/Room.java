package com.myjavablog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ROOM")
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ROOM_ID")
    private Integer id;

    @Column(name = "ROOM_NAME")
    private String roomName;

    @Column(name = "HOST_USER_ID")
    private Integer hostUserId;

    // Room Vip = 1, Normal = 0
    @Column(name = "TYPE")
    private Integer roomType;

    @Transient
    private List<Message> messages;
}
