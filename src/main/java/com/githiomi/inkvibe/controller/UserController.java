package com.githiomi.inkvibe.controller;

import com.githiomi.inkvibe.data.DTOs.UserDTO;
import com.githiomi.inkvibe.data.enums.ResponseType;
import com.githiomi.inkvibe.data.mapper.UserDTOMapper;
import com.githiomi.inkvibe.data.models.RestResponse;
import com.githiomi.inkvibe.data.models.User;
import com.githiomi.inkvibe.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.githiomi.inkvibe.data.mapper.UserDTOMapper.toUserDTO;
import static com.githiomi.inkvibe.data.mapper.UserDTOMapper.toUserDTOs;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping(value = "api/v1/users")
@Tag(name = "User", description = "CRUD operations for Users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    @Operation(summary = "List all users", description = "Get a list of all the users in the database")
    public ResponseEntity<RestResponse<List<UserDTO>>> getAllActiveUsers() {
        return ResponseEntity.status(OK).body(new RestResponse<>(toUserDTOs(this.userService.getAllUsers()), ResponseType.DATA_RESPONSE));
    }

    @GetMapping("{userId}")
    @Operation(summary = "Get user by ID", description = "Get a specific user by their ID")
    public ResponseEntity<RestResponse<UserDTO>> getUserById(@PathVariable("userId") String id) {
        return ResponseEntity.status(OK).body(new RestResponse<>(toUserDTO(this.userService.findUserById(UUID.fromString(id))), ResponseType.DATA_RESPONSE));
    }

}
