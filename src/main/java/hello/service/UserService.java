package hello.service;

import hello.model.User;

public interface UserService {
    User saveUser(User user);

    User findUserByUsername(String username) ;
}
