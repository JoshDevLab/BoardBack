package com.josh.BoardBack.service;

import com.josh.BoardBack.domain.Role;
import com.josh.BoardBack.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();

}
