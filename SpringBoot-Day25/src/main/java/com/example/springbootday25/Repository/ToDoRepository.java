package com.example.springbootday25.Repository;

import com.example.springbootday25.Model.MyUser;
import com.example.springbootday25.Model.ToDo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Integer>{
    ToDo findToDoById(Integer id);
    List<ToDo> findToDoByMyUser(MyUser myUser);
}
