package com.example.springboothw27.Service;

import com.example.springboothw27.Model.MyUser;
import com.example.springboothw27.Repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {


    private final MyUserRepository myUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user=myUserRepository.findUserByUsername(username);

        if(user==null) {
            throw new UsernameNotFoundException("Wrong username or password");
        }
        return user;
    }

}
