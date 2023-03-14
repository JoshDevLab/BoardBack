package com.josh.BoardBack.service;

import com.josh.BoardBack.user.Role;
import com.josh.BoardBack.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUser(String email);
    List<User> getUsers();

}
