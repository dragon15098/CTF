package com.myjavablog.service;

import com.myjavablog.model.Message;
import com.myjavablog.model.Room;

import java.util.List;

public interface MessageService {
    Message saveMessage(Message message);
}
