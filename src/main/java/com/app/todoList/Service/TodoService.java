package com.app.todoList.Service;

import com.app.todoList.payload.TodoDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface TodoService {

    TodoDTO createUserTodo(@Valid TodoDTO userTasks);

    List<TodoDTO> listALlUserTodo();

    TodoDTO UpdateALlUserTask(Long id, TodoDTO updatedTask);

    TodoDTO deleteUserTask(Long id);
}
