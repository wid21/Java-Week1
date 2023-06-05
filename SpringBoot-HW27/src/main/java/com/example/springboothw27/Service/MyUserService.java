package com.example.springboothw27.Service;

import com.example.springboothw27.Model.Blog;
import com.example.springboothw27.Model.MyUser;
import com.example.springboothw27.Repository.BlogRepository;
import com.example.springboothw27.Repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserService {

    private final MyUserRepository myUserRepository;
    private final BlogRepository blogRepository;

    public List<MyUser> getAllUser(){
        return myUserRepository.findAll();
    }

    public void register(MyUser myUser) {
            String hashedPassword = new BCryptPasswordEncoder().encode(myUser.getPassword());
            myUser.setPassword(hashedPassword);
            myUserRepository.save(myUser);
        }

    public void updateUser(Integer userId, MyUser user) {
        MyUser oldUser = myUserRepository.findMyUserById(userId);
        oldUser.setUsername(user.getUsername());
        String hash = new BCryptPasswordEncoder().encode(user.getPassword());
        oldUser.setPassword(hash);
        myUserRepository.save(oldUser);
    }
    public void deleteUser(MyUser myUser) {

        List<Blog> blogs = blogRepository.findBlogsByMyUser(myUser);
        for (int i = 0; i < blogs.size(); i++) {
            blogs.get(i).setMyUser(null);
        }
        MyUser oldUser = myUserRepository.findMyUserById(myUser.getId());
        myUserRepository.delete(oldUser);
    }


    }

