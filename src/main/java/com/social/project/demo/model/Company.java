package com.social.project.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Pattern(regexp = "[А-ЯҐЄІЇа-яґєії ]+", message = "Mustn't contain numbers or special characters.")
    private String name;
    @NotBlank(message = "Mustn't be empty.")
    private String description;
    @NotNull(message = "Mustn't be null.")
    @Column(name = "channel_name")
    private String channelName;
    @NotEmpty(message = "Mustn't be empty.")
    private byte[] logo;
    @NotNull(message = "Mustn't be null.")
    @Enumerated(EnumType.STRING)
    private CompanyType type;

    @OneToMany(mappedBy = "company")
    private List<Announcement> announcements;
}
