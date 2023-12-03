package com.social.project.demo.security.controlller;

import com.social.project.demo.model.Role;
import com.social.project.demo.security.dto.LoginRequest;
import com.social.project.demo.security.dto.LoginResponse;
import com.social.project.demo.security.entity.SecureUser;
import com.social.project.demo.security.util.JwtTokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.requireNonNullElse;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator tokenGenerator;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String username = requireNonNullElse(loginRequest.getUsername(), "").strip();
        String password = requireNonNullElse(loginRequest.getPassword(), "").strip();
        Authentication authentication = authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(username, password));
        SecureUser principal = (SecureUser) authentication.getPrincipal();
        String jwtToken = tokenGenerator.generateToken(username);
        return ResponseEntity.ok(new LoginResponse(jwtToken, (Role) principal.getAuthorities().toArray()[0]));
    }
}
