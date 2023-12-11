package com.blogging_durgesh.demo.Controller;

import com.blogging_durgesh.demo.Payloads.UserDto;
import com.blogging_durgesh.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {



    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> lists = new ArrayList<>();
       lists= this.userService.GetAllUsers();
       return new ResponseEntity<>(lists, HttpStatus.OK);

    }
    @GetMapping("/{uid}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int uid){

        UserDto user = userService.getUserById(uid) ;

        return new ResponseEntity<>(user, HttpStatus.OK);

    }
   @DeleteMapping("/{userId}")
   public void DeleteUser(@PathVariable int userId) {
        userService.DeleteUser(userId);
   }

   @PostMapping("/{userId}")
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable int userId) {
        UserDto user = new UserDto();
        user = this.userService.updateUser(userDto,userId);
        return user;
   }

}
