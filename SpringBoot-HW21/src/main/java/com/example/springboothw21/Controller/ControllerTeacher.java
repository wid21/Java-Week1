package com.example.springboothw21.Controller;

import com.example.springboothw21.ApiResponse.ApiResponse;
import com.example.springboothw21.Model.Address;
import com.example.springboothw21.Model.Teacher;
import com.example.springboothw21.Service.ServiceTeacher;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class ControllerTeacher {

    private final ServiceTeacher serviceTeacher;

    @GetMapping("/get")
    public ResponseEntity getAllTeacher() {
        List<Teacher> teachers = serviceTeacher.getAllTeachers();
        return ResponseEntity.status(200).body(teachers);
    }


    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher) {
        serviceTeacher.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher, @PathVariable Integer id) {
        serviceTeacher.updateTeacher(teacher, id);
        return ResponseEntity.status(200).body("Teacher Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        serviceTeacher.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher deleted");

    }

    @GetMapping("/get-address/{id}")
    public ResponseEntity getAddressTeacher(@PathVariable Integer id) {
        Address a = serviceTeacher.getTeacherDetails(id);
        return ResponseEntity.status(200).body(a);

    }




    }