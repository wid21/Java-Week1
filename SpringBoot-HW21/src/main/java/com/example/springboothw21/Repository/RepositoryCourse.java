package com.example.springboothw21.Repository;

import com.example.springboothw21.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositoryCourse extends JpaRepository<Course,Integer> {

        Course findCourseById(Integer id);
}

