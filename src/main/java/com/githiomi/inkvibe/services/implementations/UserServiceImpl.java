package com.githiomi.inkvibe.services.implementations;

import com.githiomi.inkvibe.data.models.User;
import com.githiomi.inkvibe.exceptions.ApiException;
import com.githiomi.inkvibe.repositories.UserRepository;
import com.githiomi.inkvibe.services.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }

    @Override
    public User findUserById(UUID id) {
        return this.userRepository.findById(id).orElseThrow(() -> new ApiException("No user with id: {" + id + "} found in the database"));
    }
}
