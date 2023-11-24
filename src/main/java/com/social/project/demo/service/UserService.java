package com.social.project.demo.service;

import com.social.project.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User save(User user);
}
