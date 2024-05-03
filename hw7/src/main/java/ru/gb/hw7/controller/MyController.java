package ru.gb.hw7.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MyController {

    @GetMapping({"/", "/login","/logout"})
    public String login() {
        return "/login_form";
    }


    @GetMapping("/public")
    public String user() {
        return "/public-data";
    }

    @GetMapping("/private")
    public String admin() {
        return "/private-data";
    }
}
