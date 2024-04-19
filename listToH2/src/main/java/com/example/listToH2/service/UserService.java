package com.example.listToH2.service;

import com.example.listToH2.model.User;
import com.example.listToH2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
       return userRepository.findAllUsers();
    }

    public User addUser(User user) {
       return userRepository.addToDb(user);
    }
}
