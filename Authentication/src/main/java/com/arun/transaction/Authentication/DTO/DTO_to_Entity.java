package com.arun.transaction.Authentication.DTO;

import com.arun.transaction.Authentication.Models.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class DTO_to_Entity {

    public UserDto entity_to_dto(UserInfo user){
        UserDto userDto = new UserDto(user.getName(), user.getEmail(), user.getPassword(), user.getPhone());
        return userDto;

    }


    public UserInfo dto_to_entity(UserDto userDto){
        UserInfo user = new UserInfo();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setRole("USER");
        return user;
    }
}
