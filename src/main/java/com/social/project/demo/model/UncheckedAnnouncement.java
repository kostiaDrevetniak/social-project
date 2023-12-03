package com.social.project.demo.model;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("test_collection")
@Getter
@Setter
@NoArgsConstructor
public class UncheckedAnnouncement {
    @Id
    private String id;
    @Pattern(regexp = "[А-ЯҐЄІЇа-яґєії ]+", message = "Mustn't contain numbers or special characters.")
    private String companyName;
    @NotEmpty(message = "Mustn't be empty.")
    private byte[] image;
    @NotBlank(message = "Mustn't be empty.")
    private String description;
    @FutureOrPresent(message = "Mustn't be past.")
    private LocalDateTime creationDate;
}
