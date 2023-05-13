package com.arun.transaction.Authentication.Controller;

import com.arun.transaction.Authentication.DTO.AuthRequest;
import com.arun.transaction.Authentication.DTO.UserDto;
import com.arun.transaction.Authentication.Services.UserService.JwtService;
import com.arun.transaction.Authentication.Services.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kin-mel")
public class Login_SignIn_Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/home")
    public ResponseEntity<String> getHome(){
        return ResponseEntity.ok("Welcome to Kin-mel");
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto){

        if(userService.findByEmail(userDto.getEmail()) !=null){

            return ResponseEntity.ok("Email Already exist");
        }

        userService.saveUser(userDto);
        System.out.println("success");
        return ResponseEntity.ok("User created successfully");
    }


    @PostMapping("/authenticate_user")
    public String authenticate(@RequestBody AuthRequest authRequest) throws Exception{
        System.out.println(authRequest);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword()));
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getEmail());
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
    }


}
