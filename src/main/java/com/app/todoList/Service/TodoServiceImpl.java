package com.app.todoList.Service;

import com.app.todoList.Repositories.todoRepository;
import com.app.todoList.model.userTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private todoRepository todoRepositories;

    @Override
    public userTodo createUserTodo(userTodo userTasks) {
        return todoRepositories.save(userTasks);
    }

    @Override
    public List<userTodo> listALlUserTodo() {
        return todoRepositories.findAll();
    }

    @Override
    public userTodo UpdateALlUserTask(Long id, userTodo updatedTask) {
        userTodo userTodos = todoRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not Found"));
        userTodos.setTasks(updatedTask.getTasks());
        return todoRepositories.save(userTodos);
    }

    @Override
    public userTodo deleteUserTask(Long id) {
        userTodo existingTask = todoRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not Found"));
        todoRepositories.delete(existingTask);
        return existingTask;
    }
}
