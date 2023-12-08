package com.social.project.demo.dto.response;

import com.social.project.demo.model.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class SiteAnnouncementResponse {
    private String title;
    private String description;
    private String location;
    private Double price;
    private LocalDateTime startDate;
    private String registrationLink;
    private String image;
    private String companyName;
    private List<Category> categories;
}
