package com.social.project.demo.service;

import com.social.project.demo.model.UncheckedAnnouncement;
import com.social.project.demo.repository.dto.UncheckedAnnouncementTitle;

import java.util.List;
import java.util.UUID;

public interface UncheckedAnnouncementService {
    List<UncheckedAnnouncementTitle> getAllTitles();
    List<UncheckedAnnouncementTitle> getByCompanyName(String companyName);
    UncheckedAnnouncement getById(String id);
    void delete(String id);
}
