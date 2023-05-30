package com.example.springboothw21.Repository;

import com.example.springboothw21.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryStudent extends JpaRepository<Student,Integer> {

    Student findStudentById(Integer id);
}
