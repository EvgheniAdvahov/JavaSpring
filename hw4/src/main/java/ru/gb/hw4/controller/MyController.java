package ru.gb.hw4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw4.model.User;

@Controller
@RequestMapping("/index")
public class MyController {

    @GetMapping()
    public String mainPage() {
        return "index";
    }

    @GetMapping("/{n1}/{n2}")
    public String sum(Model model, @PathVariable("n1") int n1, @PathVariable("n2") int n2) {
        model.addAttribute("sum", n1 + n2);
        return "indexSum";
    }
    @GetMapping("/param")
    public String stringParams(Model model, @RequestParam("name") String name){
        model.addAttribute("name", name);
        return "indexParam";
    }

    @GetMapping("/registrationForm")
    public String registrationForm(Model model){
        model.addAttribute("myObject", new User());
        model.addAttribute("users", User.myUserList);
        return "RegistrationForm";
    }
    @PostMapping("/createUser")
    public String createUser(User user) {
        User.myUserList.add(user);
        System.out.println(user);
        return "redirect:registrationForm";
    }



}
