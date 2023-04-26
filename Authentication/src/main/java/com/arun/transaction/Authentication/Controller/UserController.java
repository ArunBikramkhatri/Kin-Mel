package com.arun.transaction.Authentication.Controller;

import com.arun.transaction.Authentication.DTO.UserDto;
import com.arun.transaction.Authentication.Models.UserInfo;
import com.arun.transaction.Authentication.Services.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/daraz/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public ResponseEntity<String> userHome(Principal principal){

        return ResponseEntity.ok("Hello " + principal.getName());
    }

    @GetMapping("/my_details")
    public ResponseEntity<UserDto> getuserDetails(Principal principal){
        UserDto userDto =userService.findByEmail(principal.getName());
        userDto.setPassword("*******");
        return ResponseEntity.ok(userDto);
    }
}
