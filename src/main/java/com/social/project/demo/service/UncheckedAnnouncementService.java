package com.social.project.demo.service;

import com.social.project.demo.model.UncheckedAnnouncement;
import com.social.project.demo.repository.dto.UncheckedAnnouncementTitle;

import java.util.List;

public interface UncheckedAnnouncementService {
    List<UncheckedAnnouncementTitle> getAllTitles();
    UncheckedAnnouncement getById(String id);
}
