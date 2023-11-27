package com.social.project.demo.model;

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
    private String companyName;
    private byte[] image;
    private String description;
    private LocalDateTime creationDate;
}
