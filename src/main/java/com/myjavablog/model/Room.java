package com.myjavablog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_ID")
    private int id;

    @Column(name = "ROOM_NAME")
    private String roomName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ROOM_MESSAGE", joinColumns = @JoinColumn(name = "ROOM_ID"), inverseJoinColumns = @JoinColumn(name = "MESSAGE_ID"))
    private Set<Message> messages;

}
