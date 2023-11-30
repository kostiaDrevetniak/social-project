package com.social.project.demo.service.impl;

import com.social.project.demo.model.UncheckedAnnouncement;
import com.social.project.demo.repository.UncheckedAnnouncementRepository;
import com.social.project.demo.dto.response.UncheckedAnnouncementTitle;
import com.social.project.demo.service.UncheckedAnnouncementService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UncheckedAnnouncementServiceImpl implements UncheckedAnnouncementService {
    private final UncheckedAnnouncementRepository uncheckedAnnouncementRepository;
    @Override
    public List<UncheckedAnnouncementTitle> getAllTitles() {
        return uncheckedAnnouncementRepository.findIdAndCompanyNameAndCreationDate();
    }

    @Override
    public UncheckedAnnouncement getById(String id) {
        return uncheckedAnnouncementRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Unchecked announcement with id " + id + " not found"));
    }

    @Override
    public List<UncheckedAnnouncementTitle> getByCompanyName(String companyName) {
        return uncheckedAnnouncementRepository.findByCompanyName(companyName);
//        List<UncheckedAnnouncementTitle> titles = uncheckedAnnouncementRepository.findByCompanyName(companyName);
//        return (titles != null) ? titles : new ArrayList<>();
    }

    @Override
    public void delete(String id) {
        uncheckedAnnouncementRepository.deleteById(id);
    }
}
