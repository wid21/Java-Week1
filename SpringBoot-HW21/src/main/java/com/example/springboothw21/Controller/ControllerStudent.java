package com.example.springboothw21.Controller;

import com.example.springboothw21.ApiResponse.ApiResponse;
import com.example.springboothw21.Model.Course;
import com.example.springboothw21.Model.Student;
import com.example.springboothw21.Service.ServiceStudent;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class ControllerStudent {

    private  final ServiceStudent serviceStudent;

    @GetMapping("/get")
    public ResponseEntity getAllStudent() {
        List<Student> student = serviceStudent.getAllstudents();
        return ResponseEntity.status(200).body(student);
    }


    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student) {
        serviceStudent.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student student, @PathVariable Integer id) {
        serviceStudent.updateStudent(student, id);
        return ResponseEntity.status(200).body("student Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        serviceStudent.deleteStudent(id);
        return ResponseEntity.status(200).body("student deleted");

    }

    @PutMapping("/getcs/{c_id}/{s_id}")
    public ResponseEntity assighn(@PathVariable Integer c_id, @PathVariable Integer s_id) {
        serviceStudent.assighnstudentcourse(c_id, s_id);
        return ResponseEntity.status(200).body("student course");

    }

    @GetMapping("/getstudent/{c_id}")
    public ResponseEntity getstudents(@PathVariable Integer c_id){
        Set<Student> students=serviceStudent.getallcourses(c_id);
        return ResponseEntity.status(200).body(students);
    }


    @PutMapping("/getm/{id}/{major}")
    public ResponseEntity assighn(@PathVariable Integer id, @PathVariable String major) {
        serviceStudent.changemajor(id, major);
        return ResponseEntity.status(200).body("major of student has changed");

    }

}
