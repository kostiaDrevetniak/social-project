package com.social.project.demo.controller;

import com.social.project.demo.model.Company;
import com.social.project.demo.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyService.getAll();
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable UUID id) {
        return companyService.readById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        companyService.delete(id);
    }
}
