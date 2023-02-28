package com.ssen.mongo.controller;

import com.ssen.mongo.entity.User;
import com.ssen.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mongo")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/{userId}")
    public User getUser(@PathVariable String userId){
        return userService.getUser(userId);
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PutMapping("/updatemail")
    public int updateMail(@RequestBody User user){
        return userService.updateMail(user);
    }

    @DeleteMapping("/delete")
    public int delete(@RequestBody User user){
        return userService.delete(user);
    }
}
