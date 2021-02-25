package com.myjavablog.service;

import com.myjavablog.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

    User findUserByEmail(String email) ;
    User saveUser(User user);
}
