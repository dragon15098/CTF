package com.myjavablog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "INVITE")
@Getter
@Setter
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "INVITATION_ID")
    private Integer id;

    @Column(name = "ROOM_ID")
    private Integer roomId;

    @Column(name = "TO_USER_ID")
    private Integer toUserId;

    @Column(name = "STATUS")
    private Integer status;
}
