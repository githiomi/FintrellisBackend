package com.githiomi.inkvibe.controller;

import com.githiomi.inkvibe.data.enums.ResponseType;
import com.githiomi.inkvibe.data.models.ApiResponse;
import com.githiomi.inkvibe.data.models.User;
import com.githiomi.inkvibe.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<User>>> getAllActiveUsers() {
        return ResponseEntity.status(OK).body(new ApiResponse<>(this.userService.getAllUsers(), ResponseType.DATA_RESPONSE));
    }

}
