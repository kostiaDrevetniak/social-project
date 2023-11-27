package com.social.project.demo.repository.dto;

import com.social.project.demo.repository.UncheckedAnnouncementRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UncheckedAnnouncementTitle {
    private String id;
    private String companyName;
    private String creationDate;
}
