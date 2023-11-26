package com.social.project.demo.service;

import com.social.project.demo.model.Announcement;
import com.social.project.demo.model.Category;

import java.util.List;
import java.util.UUID;

public interface AnnouncementService {
    Announcement create(Announcement announcement);
    Announcement readById(UUID id);
    Announcement update(Announcement announcement);
    void delete(UUID id);
    List<Announcement> getAll();
}
