package com.example.springboothw21.Repository;

import com.example.springboothw21.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryTeacher extends JpaRepository<Teacher,Integer> {

    Teacher findTeacherById(Integer id);
    List<Teacher> getTeachersById(Integer id);
}
