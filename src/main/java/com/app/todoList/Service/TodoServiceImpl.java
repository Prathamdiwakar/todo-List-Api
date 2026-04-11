package com.app.todoList.Service;

import com.app.todoList.Repositories.UserRepository;
import com.app.todoList.Repositories.todoRepository;
import com.app.todoList.model.User;
import com.app.todoList.model.userTodo;
import com.app.todoList.payload.TodoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private todoRepository todoRepositories;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TodoDTO createUserTodo(TodoDTO userTasks) {
        userTodo todoEntity = modelMapper.map(userTasks, userTodo.class);
        User user = userRepository.findById(todoEntity.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        todoEntity.setUser(user);

        // Save in DB
        userTodo savedTodo = todoRepositories.save(todoEntity);

        // Entity → DTO
        return modelMapper.map(savedTodo, TodoDTO.class);
    }

    @Override
    public List<TodoDTO> listALlUserTodo() {
        List<userTodo> todoDTOS = todoRepositories.findAll();
        return todoDTOS.stream()
                .map(todo -> modelMapper.map(todo, TodoDTO.class))
                .toList();
    }

    @Override
    public TodoDTO UpdateALlUserTask(Long id, TodoDTO updatedTask) {
        userTodo userTodos = todoRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not Found"));
        userTodos.setTasks(updatedTask.getTasks());
        userTodos.setCompleted(updatedTask.getCompleted());

        userTodo savedUser = todoRepositories.save(userTodos);
        return modelMapper.map(savedUser, TodoDTO.class);
    }

    @Override
    public TodoDTO deleteUserTask(Long id) {
        userTodo existingTask = todoRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not Found"));
        todoRepositories.delete(existingTask);
        return modelMapper.map(existingTask, TodoDTO.class);
    }
}
