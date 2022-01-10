package com.example.demo.controllers;

import com.example.demo.DB.data.Role;
import com.example.demo.DB.data.User;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {
   private final UserService userService;
   private final UserRepo userRepo;
    public UsersController(UserService userService, UserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @GetMapping("/new")
    public String redUsers(Model model){
        model.addAttribute("users", userService.getAll());
        //model.addAttribute("username", "s");
        return "new";
    }

    @PostMapping("/new")
    public String addAdmin(@RequestParam String username, Model model){
        User user = userRepo.findFirstByUsername(username);
        if(user != null){
            user.setRole(Role.ADMIN);
            userRepo.save(user);
            model.addAttribute("users", userService.getAll());
            model.addAttribute("AddAdm", "Role is changed");

        }
        else throw new RuntimeException("user is Empty");

        return "new";
    }
}
