package com.social.project.demo.repository;

import com.social.project.demo.model.UncheckedAnnouncement;
import com.social.project.demo.repository.dto.UncheckedAnnouncementTitle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UncheckedAnnouncementRepository extends MongoRepository<UncheckedAnnouncement, String> {
    @Query("{}")
    List<UncheckedAnnouncementTitle> findIdAndCompanyNameAndCreationDate();
}
