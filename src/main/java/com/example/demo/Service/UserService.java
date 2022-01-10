package com.example.demo.Service;

import com.example.demo.DB.data.User;
import com.example.demo.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean save(UserDTO userDTO);
    List<UserDTO> getAll();
    User findByName(String name);
    void save(User user);
}
