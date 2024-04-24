package ru.gb.hw4.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private String name;
    private int age;
    private String email;

    public static List<User> myUserList = new ArrayList<>();

}
