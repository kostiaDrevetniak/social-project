package com.social.project.demo.service;

import com.social.project.demo.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User create(User user);
    User readById(UUID id);
    User update(User user);
    void delete(UUID id);
    List<User> getAll();
}
