package hello.service;

import hello.model.User;

public interface UserService {
    User findUserByEmail(String email);
    User saveUser(User user);
}
