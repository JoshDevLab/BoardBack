package com.josh.BoardBack.service;

import com.josh.BoardBack.user.Role;
import com.josh.BoardBack.user.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    User getUser(String username);
    List<User> getUsers();

}
