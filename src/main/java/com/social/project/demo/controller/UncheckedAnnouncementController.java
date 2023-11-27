package com.social.project.demo.controller;

import com.social.project.demo.model.UncheckedAnnouncement;
import com.social.project.demo.repository.dto.UncheckedAnnouncementTitle;
import com.social.project.demo.service.UncheckedAnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("api/announcement/unchecked")
public class UncheckedAnnouncementController {
    private final UncheckedAnnouncementService uncheckedAnnouncementService;

    @GetMapping("/all")
    public List<UncheckedAnnouncementTitle> getAllTitles() {
        return uncheckedAnnouncementService.getAllTitles();
    }

    @GetMapping
    public List<UncheckedAnnouncementTitle> getByCompanyName(@RequestParam("company-name") String companyName) {
        return uncheckedAnnouncementService.getByCompanyName(companyName);
    }

    @GetMapping("/{id}")
    public UncheckedAnnouncement getById(@PathVariable String id) {
        return uncheckedAnnouncementService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        uncheckedAnnouncementService.delete(id);
    }
}
