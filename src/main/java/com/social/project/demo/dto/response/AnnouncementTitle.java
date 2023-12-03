package com.social.project.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class AnnouncementTitle {
    private UUID id;
    private String title;
    private String companyName;
    private LocalDateTime creationDate;
    private LocalDateTime startDate;
}
