package com.social.project.demo.controller.site;

import com.social.project.demo.dto.MapWrapper;
import com.social.project.demo.dto.response.AnnouncementResponse;
import com.social.project.demo.dto.response.SiteAnnouncementResponse;
import com.social.project.demo.dto.response.SiteAnnouncementTitle;
import com.social.project.demo.model.Announcement;
import com.social.project.demo.model.Category;
import com.social.project.demo.service.AnnouncementService;
import com.social.project.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/announcements")
@RequiredArgsConstructor
public class SiteAnnouncementController {
    private final AnnouncementService announcementService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getTitles(@ModelAttribute("categories") MapWrapper wrapper, Model model) {
        Map<String, String> selectedCategories = wrapper.getCategories();
        List<Category> filter = selectedCategories.entrySet().stream().flatMap((entry) -> {
            if (Objects.nonNull(entry.getValue())) {
                Category category = categoryService.readById(UUID.fromString(entry.getKey()));
                return Stream.of(category);
            }
            return Stream.empty();
        }).toList();
        List<Announcement> announcements;
        if (filter.size() > 0) {
            announcements = announcementService.getByCategories(filter);
        } else {
            announcements = announcementService.getAll();
        }
        List<Category> allCategories = categoryService.getAll();
        Map<String, String> categories = allCategories.stream().collect(Collectors.toMap(c -> c.getId().toString(), Category::getName));
        model.addAttribute("categoriesMap", new MapWrapper(categories));
        model.addAttribute("announcements", announcements.stream()
                .map(announcement -> modelMapper.map(announcement, SiteAnnouncementTitle.class)).toList());
        return "/announcement-list";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable UUID id, Model model) {
        Announcement announcement = announcementService.readById(id);
        SiteAnnouncementResponse response = modelMapper.map(announcement, SiteAnnouncementResponse.class);
        model.addAttribute("announcement", response);
        return "/announcement";
    }
}