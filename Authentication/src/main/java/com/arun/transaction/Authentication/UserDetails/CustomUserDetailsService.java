package com.arun.transaction.Authentication.UserDetails;

import com.arun.transaction.Authentication.Models.UserInfo;
import com.arun.transaction.Authentication.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userRepo.findByEMail(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails userDetails = new MyUserDetails(user);

        return userDetails;
    }
}
