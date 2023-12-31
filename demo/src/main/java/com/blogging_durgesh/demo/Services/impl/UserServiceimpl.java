package com.blogging_durgesh.demo.Services.impl;

import com.blogging_durgesh.demo.Exceptions.ResourceNotFoundException;
import com.blogging_durgesh.demo.Payloads.UserDto;
import com.blogging_durgesh.demo.Repositories.UserRepo;
import com.blogging_durgesh.demo.Services.UserService;
import com.blogging_durgesh.demo.entities.Comments;
import com.blogging_durgesh.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user =this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser = this.userRepo.save(user);
        UserDto userDto1 = this.userToDto(updatedUser);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
        return this.userToDto(user);
    }

    @Override
    public void DeleteUser(Integer userId) {
         User user =  this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
         this.userRepo.delete(user);
    }

    @Override
    public List<UserDto> GetAllUsers() {
        List<User>users = this.userRepo.findAll();
       List<UserDto>collect =  users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<Comments> GetAllCommentsUser( int id) {
        User user =  this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
        return user.getCmmts();
    }

    private User dtoToUser(UserDto userDto){
       User user = new User();
       user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        return user;
    }

    private UserDto userToDto(User user){

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setAbout(user.getAbout());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
