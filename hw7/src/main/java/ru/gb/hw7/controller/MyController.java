package ru.gb.hw7.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MyController {

//
//    @GetMapping("/index")
//    public String index() {
//        return "redirect:/";
//    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/public")
    public String user() {
        return "public-data.html";
    }

    @GetMapping("/private")
    public String admin() {
        return "private-data";
    }
}
