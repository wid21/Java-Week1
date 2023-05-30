package com.example.springboothw21.Service;

import com.example.springboothw21.ApiException.ApiException;
import com.example.springboothw21.Model.Course;
import com.example.springboothw21.Model.Student;
import com.example.springboothw21.Repository.RepositoryCourse;
import com.example.springboothw21.Repository.RepositoryStudent;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ServiceStudent {

    private final RepositoryStudent repositoryStudent;
    private final RepositoryCourse repositoryCourse;

    public List<Student> getAllstudents(){
        return repositoryStudent.findAll();
    }
    public void addStudent(Student student  ){

        repositoryStudent.save(student);
    }

    public void updateStudent(Student student ,Integer id){
        Student student1 = repositoryStudent.findStudentById(id);
        if(student1==null){
            throw new ApiException("Course not found");
        }

        student1.setName(student.getName());
        repositoryStudent.save(student1);
    }


    public void deleteStudent(Integer id){
        Student student = repositoryStudent.findStudentById(id);
        if(student==null){
            throw new ApiException("student not found");
        }

        repositoryStudent.delete(student);
    }

    public void assighnstudentcourse(Integer c_id, Integer s_id){
        Student student=repositoryStudent.findStudentById(s_id);
         Course course=repositoryCourse.findCourseById(c_id);
        if(student==null || course==null){
            throw new ApiException("not found");
        }
        course.getStudent().add(student);
        student.getCourses().add(course);
        repositoryStudent.save(student);
        repositoryCourse.save(course);
    }
    public Set<Student> getallcourses(Integer c_id){
        Course courses=repositoryCourse.findCourseById(c_id);

        if (c_id==null){
            throw new ApiException("not found");
        }
        return courses.getStudent();

    }

    public void changemajor(Integer id , String major){
        Student student=repositoryStudent.findStudentById(id);
        if(student==null){
            throw new ApiException("student not found"); }
        Set<Course> courses = student.getCourses();
        for (Course course : courses) {
            course.getStudent().remove(student);
            repositoryCourse.save(course); }
        student.setMajor(major);
        repositoryStudent.save(student);
    }



}
