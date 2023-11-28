package com.social.project.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

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
    @Pattern(regexp = "[А-ЯҐЄІЇа-яґєії ]+", message = "Mustn't contain numbers or special characters.")
    private String title;
//  Не знаю як тут написати
    private String description;
    @Pattern(regexp = "[А-ЯҐЄІЇа-яґєії0-9 ]", message = "Mustn't contain special characters.")
    private String location;
    @Min(value = 0, message = "Must be greater or equal 0.")
    private Double price;
    @FutureOrPresent(message = "Mustn't be past")
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @URL(message = "Must be a URL.")
    @Column(name = "registration_link")
    private String registrationLink;
    @NotBlank(message = "Mustn't be empty.")
    private byte[] image;

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
