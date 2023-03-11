package com.josh.BoardBack.service;

import com.josh.BoardBack.domain.Role;
import com.josh.BoardBack.domain.User;
import com.josh.BoardBack.repo.RoleRepo;
import com.josh.BoardBack.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public Role saveRole(Role role) {
        return null;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}

