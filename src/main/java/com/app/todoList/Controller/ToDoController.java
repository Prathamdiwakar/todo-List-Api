package com.app.todoList.Controller;

import com.app.todoList.Service.TodoService;
import com.app.todoList.payload.TodoDTO;
import jakarta.validation.Valid;
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
    public ResponseEntity<TodoDTO> addTask(@Valid @RequestBody TodoDTO userTasks){
        TodoDTO savedTasks = todoService.createUserTodo(userTasks);
        return new ResponseEntity<>(savedTasks, HttpStatus.CREATED);
    }

    @GetMapping("/List")
    public ResponseEntity<List<TodoDTO>> ListTask(){
        List<TodoDTO> AllTasks = todoService.listALlUserTodo();
        return new ResponseEntity<>(AllTasks, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TodoDTO> updateTask(@Valid @PathVariable Long id,@RequestBody TodoDTO updatedTask){
        TodoDTO AllTasks = todoService.UpdateALlUserTask(id,updatedTask);
        return new ResponseEntity<>(AllTasks, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteTask(@PathVariable Long id){
        TodoDTO AllTasks = todoService.deleteUserTask(id);
        return new ResponseEntity<>("task deleted Successfully", HttpStatus.OK);
    }
}
