package com.githiomi.inkvibe.services;

import com.githiomi.inkvibe.data.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User findUserByUsername(String username);

    User findUserById(UUID id);
}
