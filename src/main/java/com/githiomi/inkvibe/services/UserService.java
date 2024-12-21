package com.githiomi.inkvibe.services;

import com.githiomi.inkvibe.data.models.User;

import java.util.UUID;

public interface UserService {

    User saveUser(User user);

    User findUserByUsername(String username);

    User findUserById(UUID id);
}
