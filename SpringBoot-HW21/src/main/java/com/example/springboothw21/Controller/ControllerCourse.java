package com.example.springboothw21.Controller;

import com.example.springboothw21.ApiResponse.ApiResponse;
import com.example.springboothw21.Model.Address;
import com.example.springboothw21.Model.Course;
import com.example.springboothw21.Model.Teacher;
import com.example.springboothw21.Service.ServiceCourse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class ControllerCourse {

    private final ServiceCourse serviceCourse;

    @GetMapping("/get")
    public ResponseEntity getAllCourses() {
        List<Course> courses = serviceCourse.getAllCourse();
        return ResponseEntity.status(200).body(courses);
    }


    @PostMapping("/add")
    public ResponseEntity addCourses(@Valid @RequestBody Course course ) {
        serviceCourse.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("course added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourses(@Valid @RequestBody Course course, @PathVariable Integer id) {
        serviceCourse.updateCourse(course,id);
        return ResponseEntity.status(200).body("course Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourses(@PathVariable Integer id) {
        serviceCourse.deletecourse(id);
        return ResponseEntity.status(200).body("course deleted");

    }

    @PutMapping("/addcTot/{t_id}/{c_id}")
    public ResponseEntity getCourserTeacher(@PathVariable Integer t_id , @PathVariable Integer c_id){
        serviceCourse.assignMerchantToBranch(t_id,c_id);
        return ResponseEntity.status(200).body(new ApiResponse("course added "));
    }

    @GetMapping("/get-teacher/{id}")
    public ResponseEntity getTeacherName(@PathVariable Integer id) {
        String t =serviceCourse.getTeacherName(id);
        return ResponseEntity.status(200).body("teacher name of the course is " + t);

    }


}
