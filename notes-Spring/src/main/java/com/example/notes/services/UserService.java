package com.example.notes.services;

import com.example.notes.dto.UserDTO;
import com.example.notes.models.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDTO getUserById(Long id);

    User findByUserName(String username);
}

