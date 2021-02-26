package com.myjavablog.service;

import com.myjavablog.model.Message;
import com.myjavablog.model.Room;

import java.util.List;
import java.util.Map;

public interface MessageService {
    Message saveMessage(Map<String, String> map, Integer roomId);
}
