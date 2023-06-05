package com.example.springboothw27.Controller;

import com.example.springboothw27.Model.MyUser;
import com.example.springboothw27.Service.MyUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class MyUserController {


private final MyUserService myUserService;

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody MyUser myUser){
        myUserService.register(myUser);
        return ResponseEntity.status(200).body(" user registered ");
    }

    @GetMapping("/get")
    public ResponseEntity getuser(){
        List <MyUser> myUserList=myUserService.getAllUser();
        return ResponseEntity.status(200).body(myUserList);
    }

    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body("Login");
    }

    @PostMapping("/logout")
    public ResponseEntity logout(){
        return ResponseEntity.status(200).body("Logout");
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@AuthenticationPrincipal MyUser myUser, @Valid @RequestBody MyUser user) {
        myUserService.updateUser(myUser.getId(), user);
        return ResponseEntity.status(200).body("user updated");
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@AuthenticationPrincipal MyUser myUser ){
        myUserService.deleteUser(myUser);
        return ResponseEntity.status(200).body("user Deleted");
    }


}
