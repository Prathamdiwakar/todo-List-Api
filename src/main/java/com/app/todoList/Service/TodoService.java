package com.app.todoList.Service;

import com.app.todoList.model.userTodo;

import java.util.List;
import java.util.Objects;

public interface TodoService {

    userTodo createUserTodo(userTodo userTasks);

    List<userTodo> listALlUserTodo();

    userTodo UpdateALlUserTask(Long id, userTodo updatedTask);

    userTodo deleteUserTask(Long id);
}
