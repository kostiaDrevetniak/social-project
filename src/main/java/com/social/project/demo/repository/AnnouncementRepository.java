package com.social.project.demo.repository;

import com.social.project.demo.dto.response.AnnouncementTitle;
import com.social.project.demo.model.Announcement;
import com.social.project.demo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AnnouncementRepository extends JpaRepository<Announcement, UUID> {
    @Query("select new com.social.project.demo.dto.response.AnnouncementTitle" +
            "(an.id, an.title, an.company.name, an.creationDate, an.startDate) from Announcement an")
    List<AnnouncementTitle> getAllTitles();

    @Query("select new com.social.project.demo.dto.response.AnnouncementTitle" +
            "(an.id, an.title, an.company.name, an.creationDate, an.startDate) " +
            "from Announcement an where an.company = ?1")
    List<AnnouncementTitle> getTitlesByCompany(Company company);
}
