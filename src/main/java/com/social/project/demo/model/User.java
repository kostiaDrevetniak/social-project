package com.social.project.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Pattern(regexp = "[А-ЯҐЄІЇ][а-яґєії]+ [А-ЯҐЄІЇ][а-яґєії]+", message = "Must contain two words starting with " +
            "uppercase ukrainian letter followed by one or more lowercase letters.")
    private String username;
    @Pattern(regexp = "[A-Za-z\\d]{6,}]", message = "Must be longer than 5 symbols using digits and latin letters.")
    @Pattern(regexp = ".*\\d.*", message = "Must contain at least one digit.")
    @Pattern(regexp = ".*[A-Z].*]", message = "Must contain at least one uppercase letter.")
    @Pattern(regexp = ".*[a-z].*]", message = "Must contain at least ine lowercase letter.")
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
