package com.myjavablog.model;


import javax.persistence.*;

@Entity
@Table(name = "MESSAGE")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MESSAGE_ID")
    private int id;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "USER_ID")
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
