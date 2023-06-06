package com.example.springbootday25.Controller;

import com.example.springbootday25.Model.MyUser;
import com.example.springbootday25.Model.ToDo;
import com.example.springbootday25.Service.ServiceToDo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
public class ControllerToDo {

    private final ServiceToDo serviceToDo;

    @GetMapping("/get")
    public ResponseEntity getTodos(@AuthenticationPrincipal MyUser myUser ){//take the id of the object

        List<ToDo> toDoList=serviceToDo.getTodos(myUser.getId());
        return ResponseEntity.status(200).body(toDoList);
    }

    @PostMapping("/add")
    public ResponseEntity addTodo(@AuthenticationPrincipal MyUser myUser , @Valid @RequestBody ToDo toDo){
        serviceToDo.addTodo(myUser.getId(),toDo);
        return ResponseEntity.status(200).body("user added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTodo(@AuthenticationPrincipal MyUser myUser , @RequestBody ToDo toDo,@PathVariable Integer id){
        serviceToDo.updateTodo(myUser.getId(),toDo,id);
        return ResponseEntity.status(200).body("user updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTodo(@AuthenticationPrincipal MyUser myUser ,@PathVariable Integer id){
        serviceToDo.deleteTodo(myUser.getId(),id);
        return ResponseEntity.status(200).body("user deleted");
    }

}
