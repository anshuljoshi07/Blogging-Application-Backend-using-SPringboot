package com.blogging_durgesh.demo.Services;

import com.blogging_durgesh.demo.Payloads.UserDto;
import com.blogging_durgesh.demo.entities.Comments;
import com.blogging_durgesh.demo.entities.User;

import java.util.List;

public interface UserService {



     UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    void DeleteUser(Integer userId);
    List<UserDto> GetAllUsers();

    List<Comments> GetAllCommentsUser( int id);
}
