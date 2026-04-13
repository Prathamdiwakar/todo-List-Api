package com.app.todoList.Service;

import com.app.todoList.Repositories.UserRepository;
import com.app.todoList.model.User;
import com.app.todoList.payload.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO addUserName(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User userFromDb = userRepository.save(user);
        return  modelMapper.map(userFromDb, UserDTO.class);
    }
}
