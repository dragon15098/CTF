package com.myjavablog.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MESSAGE")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private int id;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "MESSAGE_OPTION")
    private String messageOptionStr;

    @Transient
    private List<Object> messageOption;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessageOptionStr() {
        return messageOptionStr;
    }

    public void setMessageOptionStr(String messageOptionStr) {
        this.messageOptionStr = messageOptionStr;
    }

    public List<Object> getMessageOption() {
        return messageOption;
    }

    public void setMessageOption(List<Object> messageOption) {
        this.messageOption = messageOption;
    }

    public String getStyle() {
        if (messageOption != null) {
            for (Object o : messageOption) {
                if (o instanceof TextStyle) {
                    return ((TextStyle) o).getValue();
                }
            }
        }
        return "";
    }

    public String getColor() {
        if (messageOption != null) {
            for (Object o : messageOption) {
                if (o instanceof TextColor) {
                    return ((TextColor) o).getValue();
                }
            }
        }
        return "#000000";
    }

}
