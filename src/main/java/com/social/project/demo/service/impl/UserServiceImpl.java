package com.social.project.demo.service.impl;

import com.social.project.demo.model.User;
import com.social.project.demo.repository.UserRepository;
import com.social.project.demo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        if (user == null)
            throw new IllegalArgumentException("User cannot be 'null'");
        return userRepository.save(user);
    }

    @Override
    public User readById(UUID id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public User update(User user) {
        if (user == null)
            throw new IllegalArgumentException("User cannot be 'null'");
        readById(user.getId());
        return userRepository.save(user);
    }

    @Override
    public void delete(UUID id) {
        User user = readById(id);
        userRepository.delete(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
