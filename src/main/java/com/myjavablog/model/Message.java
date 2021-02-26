package com.myjavablog.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MESSAGE")
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
