package com.githiomi.inkvibe.controller;

import com.githiomi.inkvibe.data.enums.ResponseType;
import com.githiomi.inkvibe.data.models.RestResponse;
import com.githiomi.inkvibe.data.models.User;
import com.githiomi.inkvibe.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "List all users", description = "Get a list of all the users in the database")
    public ResponseEntity<RestResponse<List<User>>> getAllActiveUsers() {
        return ResponseEntity.status(OK).body(new RestResponse<>(this.userService.getAllUsers(), ResponseType.DATA_RESPONSE));
    }

}
