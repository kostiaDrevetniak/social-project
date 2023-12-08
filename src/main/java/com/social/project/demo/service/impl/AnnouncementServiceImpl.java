package com.social.project.demo.service.impl;

import com.social.project.demo.dto.response.AnnouncementTitle;
import com.social.project.demo.model.Announcement;
import com.social.project.demo.model.Category;
import com.social.project.demo.model.Company;
import com.social.project.demo.repository.AnnouncementRepository;
import com.social.project.demo.service.AnnouncementService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;

    @Override
    public Announcement create(Announcement announcement) {
        if (announcement == null)
            throw new IllegalArgumentException("Announcement cannot be 'null'");
        return announcementRepository.save(announcement);
    }

    @Override
    public Announcement readById(UUID id) {
        return announcementRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Announcement with id " + id + " not found"));
    }

    @Override
    public Announcement update(Announcement announcement) {
        if (announcement == null)
            throw new IllegalArgumentException("Announcement cannot be 'null'");
        readById(announcement.getId());
        return announcementRepository.save(announcement);
    }

    @Override
    public void delete(UUID id) {
        Announcement announcement = readById(id);
        announcementRepository.delete(announcement);
    }

    @Override
    public List<Announcement> getAll() {
        return announcementRepository.findAll();
    }

    @Override
    public List<AnnouncementTitle> getAllTitles() {
        return announcementRepository.getAllTitles();
    }

    @Override
    public List<AnnouncementTitle> getTitlesByCompany(Company company) {
        return announcementRepository.getTitlesByCompany(company);
    }

    @Override
    public List<Announcement> getByCategories(List<Category> categories) {
        return announcementRepository.getAnnouncementByCategories(categories);
    }
}
