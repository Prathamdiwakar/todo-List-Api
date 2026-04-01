package com.app.todoList.Repositories;

import com.app.todoList.model.userTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface todoRepository extends JpaRepository<userTodo, Long > {


}
