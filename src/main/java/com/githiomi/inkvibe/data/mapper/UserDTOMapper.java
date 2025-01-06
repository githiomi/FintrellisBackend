package com.githiomi.inkvibe.data.mapper;

import com.githiomi.inkvibe.data.DTOs.UserDTO;
import com.githiomi.inkvibe.data.models.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDTOMapper {

    public static UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }

    public static List<UserDTO> toUserDTOs(List<User> users){
        List<UserDTO> userDTOs = new ArrayList<>();
        users.stream().map(UserDTOMapper::toUserDTO).forEach(userDTOs::add);
        return userDTOs;
    }

    public static User toUser(UserDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        return user;
    }

}
