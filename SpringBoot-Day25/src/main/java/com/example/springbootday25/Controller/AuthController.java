package com.example.springbootday25.Controller;

import com.example.springbootday25.Model.MyUser;
import com.example.springbootday25.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        List<MyUser> myUserList=authService.getAllUser();
        return ResponseEntity.status(200).body(myUserList);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody MyUser myUser){
        authService.register(myUser);
        return ResponseEntity.status(200).body(" user RE ");
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
        authService.updateUser(myUser.getId(), user);
        return ResponseEntity.status(200).body("user updated");
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@AuthenticationPrincipal MyUser myUser ){
        authService.deleteUser(myUser);
        return ResponseEntity.status(200).body("user Deleted");
    }

}
