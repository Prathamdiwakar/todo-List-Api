package com.app.todoList.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TodoDTO {

    private Long id;
    private String tasks;
    private Boolean completed;
    private UserDTO user;
}
