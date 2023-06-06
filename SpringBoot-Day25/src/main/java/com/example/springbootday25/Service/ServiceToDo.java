package com.example.springbootday25.Service;

import com.example.springbootday25.ApiException.ApiException;
import com.example.springbootday25.Model.MyUser;
import com.example.springbootday25.Model.ToDo;
import com.example.springbootday25.Repository.AuthRepository;
import com.example.springbootday25.Repository.ToDoRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceToDo {

    private final ToDoRepository toDoRepository;
    private final AuthRepository authRepository;


    public List<ToDo> getTodos(Integer userId) {

        return toDoRepository.findToDoByMyUser(authRepository.findMyUserById(userId));
    }

    public void addTodo(Integer userId, ToDo toDo) {
        toDo.setMyUser(authRepository.findMyUserById(userId));
        toDoRepository.save(toDo);

    }

    public void updateTodo(Integer userId, ToDo toDo, Integer todoId) {
        ToDo toDo1 = toDoRepository.findToDoById(todoId);

        if (toDo1 == null){
            throw new ApiException("todo Not Found");
        }

        if (userId!=(toDo1.getMyUser().getId())){
            throw new ApiException("Not -Authorized");
        }

        toDo1.setMessage(toDo.getMessage());
        toDoRepository.save(toDo1);
    }

    public void deleteTodo(Integer userId, Integer todoid) {
        ToDo foundToDo = toDoRepository.findToDoById(todoid);
        if (foundToDo == null){
            throw new ApiException("todo Not Found");
        }

        if (!(userId.equals(foundToDo.getMyUser().getId()))){
            throw new ApiException("Not Authorized");
        }
            toDoRepository.delete(foundToDo);
        }

}
