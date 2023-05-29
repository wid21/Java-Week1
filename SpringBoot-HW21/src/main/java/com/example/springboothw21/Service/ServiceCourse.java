package com.example.springboothw21.Service;

import com.example.springboothw21.ApiException.ApiException;
import com.example.springboothw21.Model.Address;
import com.example.springboothw21.Model.Course;
import com.example.springboothw21.Model.Teacher;
import com.example.springboothw21.Repository.RepositoryCourse;
import com.example.springboothw21.Repository.RepositoryTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ServiceCourse {

    private final RepositoryCourse repositoryCourse;
    private final RepositoryTeacher repositoryTeacher;

    public List<Course> getAllCourse(){
        return repositoryCourse.findAll();
    }
    public void addCourse(Course course ){
        repositoryCourse.save(course);
    }

    public void updateCourse(Course course,Integer id){
        Course oldcourse= repositoryCourse.findCourseById(id);
        if(oldcourse==null){
            throw new ApiException("Course not found");
        }

        oldcourse.setName(course.getName());
        oldcourse.setNumber(course.getNumber());
        repositoryCourse.save(oldcourse);
    }


    public void deletecourse(Integer id){
        Course oldcourse= repositoryCourse.findCourseById(id);
         oldcourse= repositoryCourse.findCourseById(id);
        if(oldcourse==null){
            throw new ApiException("Course not found");
        }

        repositoryCourse.delete(oldcourse);
    }

    public void assignMerchantToBranch(Integer t_id,Integer c_id){
        Teacher t= repositoryTeacher.findTeacherById(t_id);
        Course c =repositoryCourse.findCourseById(c_id);

        if(t==null || c==null){
            throw new ApiException("not found");
        }

        c.setTeacher(t);
        repositoryCourse.save(c);

    }


    public String getTeacherName(Integer id) {
        Course c = repositoryCourse.findCourseById(id);
        if (c == null) {
            throw new ApiException("Course not found");
        }
        Teacher t = c.getTeacher();
        return t.getName();
    }

}
