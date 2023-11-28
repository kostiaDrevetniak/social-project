package com.social.project.demo.controller;

import com.social.project.demo.model.Announcement;
import com.social.project.demo.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/announcement/checked")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @GetMapping("/all")
    public List<Announcement> getAllAnnouncements() {
        return announcementService.getAll();
    }

    @GetMapping("/{id}")
    public Announcement getById(@PathVariable UUID id) {
        return announcementService.readById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        announcementService.delete(id);
    }
}
