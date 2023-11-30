package com.social.project.demo.service;

import com.social.project.demo.model.UncheckedAnnouncement;
import com.social.project.demo.dto.response.UncheckedAnnouncementTitle;

import java.util.List;

public interface UncheckedAnnouncementService {
    List<UncheckedAnnouncementTitle> getAllTitles();
    List<UncheckedAnnouncementTitle> getByCompanyName(String companyName);
    UncheckedAnnouncement getById(String id);
    void delete(String id);
}
