package com.social.project.demo.security.service;

import com.social.project.demo.model.User;
import com.social.project.demo.repository.UserRepository;
import com.social.project.demo.security.entity.SecureUser;
import com.social.project.demo.security.entity.SecureUser.SecureUserBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        SecureUserBuilder builder = SecureUser.builder();
        builder.id(user.getId());
        builder.authorities(List.of(user.getRole()));
        builder.username(user.getUsername());
        builder.password(user.getPassword());
        return builder.build();
    }
}
