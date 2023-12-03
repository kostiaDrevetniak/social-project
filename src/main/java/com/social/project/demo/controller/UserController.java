package com.social.project.demo.controller;

import com.social.project.demo.model.User;
import com.social.project.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> readAll() {
        return userService.getAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        System.out.println(user);
        return userService.create(user);
    }

}
