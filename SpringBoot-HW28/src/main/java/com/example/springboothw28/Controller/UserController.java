package com.example.springboothw28.Controller;


import com.example.springboothw28.Model.User;
import com.example.springboothw28.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody User user){
        userService.register(user);
        return ResponseEntity.status(200).body(" user registered ");
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
    public ResponseEntity updateUser(@AuthenticationPrincipal User muser, @Valid @RequestBody User user) {
        userService.updateUser(muser.getId(), user);
        return ResponseEntity.status(200).body("user updated");
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@AuthenticationPrincipal User  user ){
        userService.deleteUser(user);
        return ResponseEntity.status(200).body("User Deleted");
    }

    @GetMapping("/get-id/{userId}")
    public ResponseEntity getUserById(@PathVariable Integer userId){
        User user = userService.getUserId(userId);
        return ResponseEntity.status(200).body(user);
    }

}
