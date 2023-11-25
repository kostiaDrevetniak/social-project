package com.social.project.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "announcements")
@Getter
@Setter
@NoArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;
    private String location;
    private Double price;
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Column(name = "registration_link")
    private String registrationLink;
    private BufferedImage image;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Company organization;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private User reviewer;


    @ManyToMany
    @JoinTable(
            name = "announcement_categories",
            joinColumns = @JoinColumn(name = "announcement_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
}
