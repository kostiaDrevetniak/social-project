package com.social.project.demo.service;

import com.social.project.demo.dto.response.AnnouncementTitle;
import com.social.project.demo.model.Announcement;
import com.social.project.demo.model.Category;
import com.social.project.demo.model.Company;

import java.util.List;
import java.util.UUID;

public interface AnnouncementService {
    Announcement create(Announcement announcement);
    Announcement readById(UUID id);
    Announcement update(Announcement announcement);
    void delete(UUID id);
    List<Announcement> getAll();
    List<AnnouncementTitle> getAllTitles();
    List<AnnouncementTitle> getTitlesByCompany(Company company);
    List<Announcement> getByCategories(List<Category> categories);
}
