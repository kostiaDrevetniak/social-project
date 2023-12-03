package com.social.project.demo.dto.response;

import com.social.project.demo.dto.CategoryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class AnnouncementResponse {
    private String title;
    private String description;
    private String location;
    private Double price;
    private LocalDateTime startDate;
    private String registrationLink;
    private byte[] image;
    private UUID companyId;
    private List<CategoryDto> categories;
}
