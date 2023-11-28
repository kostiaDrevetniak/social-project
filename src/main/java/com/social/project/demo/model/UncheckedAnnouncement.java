package com.social.project.demo.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Getter
@Setter
@NoArgsConstructor
public class UncheckedAnnouncement {
    @Id
    private String id;
    @Pattern(regexp = "[А-ЯҐЄІЇа-яґєії ]+", message = "Mustn't contain numbers or special characters.")
    private String companyName;
    @NotBlank(message = "Mustn't be empty.")
    private byte[] image;
//  Не знаю як тут написати
    private String description;
    @FutureOrPresent(message = "Mustn't be past.")
    private LocalDateTime creationDate;
    @Future(message = "Must be future.")
    private LocalDateTime startDate;
}
