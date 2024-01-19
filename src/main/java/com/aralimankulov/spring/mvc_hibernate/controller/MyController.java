package com.aralimankulov.spring.mvc_hibernate.controller;

import com.aralimankulov.spring.mvc_hibernate.model.User;
import com.aralimankulov.spring.mvc_hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "user-info";
    }

    @RequestMapping("/saveUser")
    public String saveEmployee(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam("userId") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user-info";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id){
        userService.deleteUser(id);
        return "redirect:/";
    }
}
