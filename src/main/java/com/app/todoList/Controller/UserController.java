package com.app.todoList.Controller;

import com.app.todoList.Service.UserService;
import com.app.todoList.payload.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserDTO> addUserDetails(@RequestBody UserDTO userDTO){
        UserDTO savedUSer = userService.addUserName(userDTO);
        return new ResponseEntity<>(savedUSer, HttpStatus.OK);
    }
}
