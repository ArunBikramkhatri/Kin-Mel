package com.arun.transaction.Authentication.Services.UserService;

import com.arun.transaction.Authentication.DTO.DTO_to_Entity;
import com.arun.transaction.Authentication.DTO.UserDto;
import com.arun.transaction.Authentication.Repo.UserRepo;
import com.arun.transaction.Authentication.Models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DTO_to_Entity dtoToEntity;
    public void saveUser(UserDto userDto){
        System.out.println(userDto);
        UserInfo user = dtoToEntity.dto_to_entity(userDto);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    public UserDto findByEmail(String email){
        UserInfo user = userRepo.findByEMail(email);
        if(user == null){
            return null;
        }

        return dtoToEntity.entity_to_dto(user);
    }
}
