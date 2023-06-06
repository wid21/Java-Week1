package com.example.springbootday25.Service;

import com.example.springbootday25.Model.MyUser;
import com.example.springbootday25.Model.ToDo;
import com.example.springbootday25.Repository.AuthRepository;
import com.example.springbootday25.Repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    private final ToDoRepository toDoRepository;
    public List<MyUser> getAllUser(){
        return authRepository.findAll();
    }


    public void register(MyUser myUser){
        String hashedPassword = new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        myUser.setRole("USER");
        authRepository.save(myUser);
    }

    public void updateUser(Integer userId, MyUser user) {
        MyUser oldUser = authRepository.findMyUserById(userId);
        oldUser.setUsername(user.getUsername());
        String hash = new BCryptPasswordEncoder().encode(user.getPassword());
        oldUser.setPassword(hash);
        authRepository.save(oldUser);
    }
    public void deleteUser(MyUser myUser) {

        List<ToDo> toDoList = toDoRepository.findToDoByMyUser(myUser);
        for (int i = 0; i < toDoList.size(); i++) {
            toDoList.get(i).setMyUser(null);
        }
        MyUser oldUser = authRepository.findMyUserById(myUser.getId());
        authRepository.delete(oldUser);
    }

}
