package com.social.project.demo.controller.api;

import com.social.project.demo.dto.request.AnnouncementRequest;
import com.social.project.demo.dto.response.AnnouncementResponse;
import com.social.project.demo.dto.response.AnnouncementTitle;
import com.social.project.demo.model.Announcement;
import com.social.project.demo.model.Company;
import com.social.project.demo.security.entity.SecureUser;
import com.social.project.demo.service.AnnouncementService;
import com.social.project.demo.service.CompanyService;
import com.social.project.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/announcement/checked")
public class AnnouncementController {
    private final AnnouncementService announcementService;
    private final CompanyService companyService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    @GetMapping("/all")
    public List<AnnouncementTitle> getAllAnnouncementsTitles() {
        return announcementService.getAllTitles();
    }

    @GetMapping
    public List<AnnouncementTitle> getTitlesByCompanyId(@RequestParam(name = "company") UUID id) {
        Company company = companyService.readById(id);
        return announcementService.getTitlesByCompany(company);
    }

    @GetMapping("/{id}")
    public AnnouncementResponse getById(@PathVariable UUID id) {
        return modelMapper.map(announcementService.readById(id), AnnouncementResponse.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        announcementService.delete(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AnnouncementRequest request) {
        Announcement announcement = modelMapper.map(request, Announcement.class);
        SecureUser authenticatedUser = (SecureUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        announcement.setReviewer(userService.readById(authenticatedUser.getId()));
        announcement.setCreationDate(LocalDateTime.now());
        Announcement created = announcementService.create(announcement);
        return ResponseEntity.created(URI.create("/api/announcement/checked/" + created.getId())).body(modelMapper.map(created, AnnouncementResponse.class));
    }

    @PutMapping("/{id}")
    public void update(@RequestBody AnnouncementRequest request,
                       @PathVariable UUID id) {
        Announcement announcement = modelMapper.map(request, Announcement.class);
        announcement.setId(id);
        SecureUser authenticatedUser = (SecureUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        announcement.setReviewer(userService.readById(authenticatedUser.getId()));
        announcement.setCreationDate(announcementService.readById(id).getCreationDate());
        announcementService.update(announcement);
    }
}
