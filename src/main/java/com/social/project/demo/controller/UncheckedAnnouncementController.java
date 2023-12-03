package com.social.project.demo.controller;

import com.social.project.demo.dto.response.AnnouncementResponse;
import com.social.project.demo.dto.response.UncheckedAnnouncementTitle;
import com.social.project.demo.model.Company;
import com.social.project.demo.model.UncheckedAnnouncement;
import com.social.project.demo.service.CompanyService;
import com.social.project.demo.service.UncheckedAnnouncementService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("api/announcement/unchecked")
public class UncheckedAnnouncementController {
    private final UncheckedAnnouncementService uncheckedAnnouncementService;
    private final CompanyService companyService;
    private final ModelMapper modelMapper;

    @GetMapping("/all")
    public List<UncheckedAnnouncementTitle> getAllTitles() {
        return uncheckedAnnouncementService.getAllTitles();
    }

    @GetMapping
    public List<UncheckedAnnouncementTitle> getByCompany(@RequestParam("company") UUID companyId) {
        Company company = companyService.readById(companyId);
        return uncheckedAnnouncementService.getByCompanyName(company.getChannelName());
    }

    @GetMapping("/{id}")
    public UncheckedAnnouncement getById(@PathVariable String id) {
        UncheckedAnnouncement announcement = uncheckedAnnouncementService.getById(id);
        Company company = companyService.getByChannelName(announcement.getCompanyName());
        AnnouncementResponse response = modelMapper.map(announcement, AnnouncementResponse.class);
        response.setCompanyId(company.getId());
        return uncheckedAnnouncementService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        uncheckedAnnouncementService.delete(id);
    }
}
