package com.example.demo.controllers;

import com.example.demo.DB.data.User;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
        private final UserRepo userRepo;
     private final UserService userService;
    @Autowired
    public RegistrationController(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new UserDTO());
        return "/registration";
    }
    @PostMapping("/registration")

    public String reg(UserDTO userDto, Model model){
        User user = userRepo.findFirstByUsername(userDto.getUsername());
        if (user == null){
            userService.save(userDto);
            return "redirect:/login";
        }
       else{ model.addAttribute("user", userDto);
           model.addAttribute("errorUser","USER IS NOT SAFE");
           return "registration";
       }

    }

}
