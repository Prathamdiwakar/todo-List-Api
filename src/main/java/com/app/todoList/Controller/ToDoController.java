package com.app.todoList.Controller;

import com.app.todoList.Service.TodoService;
import com.app.todoList.model.userTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/add")
    public ResponseEntity<userTodo> addTask(@RequestBody userTodo userTasks){
        userTodo savedTasks = todoService.createUserTodo(userTasks);
        return new ResponseEntity<>(savedTasks, HttpStatus.CREATED);
    }

    @GetMapping("/List")
    public ResponseEntity<List<userTodo>> ListTask(){
        List<userTodo> AllTasks = todoService.listALlUserTodo();
        return new ResponseEntity<>(AllTasks, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<userTodo> updateTask(@PathVariable Long id,@RequestBody userTodo updatedTask){
        userTodo AllTasks = todoService.UpdateALlUserTask(id,updatedTask);
        return new ResponseEntity<>(AllTasks, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteTask(@PathVariable Long id){
        userTodo AllTasks = todoService.deleteUserTask(id);
        return new ResponseEntity<>("task deleted Successfully", HttpStatus.OK);
    }
}
