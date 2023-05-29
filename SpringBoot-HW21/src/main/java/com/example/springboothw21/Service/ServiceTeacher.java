package com.example.springboothw21.Service;

import com.example.springboothw21.ApiException.ApiException;
import com.example.springboothw21.Model.Address;
import com.example.springboothw21.Model.Teacher;
import com.example.springboothw21.Repository.RepositoryTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceTeacher {

    private final RepositoryTeacher repositoryTeacher;

    public List<Teacher> getAllTeachers(){
        return repositoryTeacher.findAll();
    }

    public void addTeacher(Teacher teacher){
        repositoryTeacher.save(teacher);
    }

    public Address getTeacherDetails(Integer id) {
        Teacher t = repositoryTeacher.findTeacherById(id);
        if (t.getAddress() == null) {
            throw new ApiException("no address for this teacher");
        }
        if (t == null) {
            throw new ApiException("not found");
        }
        Address address = t.getAddress();
        return address;
    }

    public void updateTeacher(Teacher teacher,Integer id){
        Teacher oldTeacher= repositoryTeacher.findTeacherById(id);
        if(oldTeacher==null){
            throw new ApiException("customer not found");
        }

        oldTeacher.setName(teacher.getName());
        repositoryTeacher.save(oldTeacher);
    }


    public void deleteTeacher(Integer id){
        Teacher teacher= repositoryTeacher.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("teacher not found");
        }

        repositoryTeacher.delete(teacher);
    }



}
