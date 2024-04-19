package com.example.listToH2.controllers;

import com.example.listToH2.model.User;
import com.example.listToH2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    @ResponseBody
    public List<User> userList(){
        return userService.findAll();
    }

    @PostMapping("/body")
    public void userAddFromBody(@RequestBody User user){
        userService.addUser(user);
//        return "User added to database";
    }


}
