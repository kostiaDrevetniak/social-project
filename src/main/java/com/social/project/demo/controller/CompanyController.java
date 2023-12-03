package com.social.project.demo.controller;

import com.social.project.demo.dto.request.CompanyRequest;
import com.social.project.demo.dto.response.CompanyName;
import com.social.project.demo.dto.response.CompanyResponse;
import com.social.project.demo.model.Company;
import com.social.project.demo.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyService companyService;
    private final ModelMapper modelMapper;

    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyService.getAll();
    }

    @GetMapping("/{id}")
    public CompanyResponse getById(@PathVariable UUID id) {
        return modelMapper.map(companyService.readById(id), CompanyResponse.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        companyService.delete(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CompanyRequest companyRequest) {
        Company company = modelMapper.map(companyRequest, Company.class);
        Company created = companyService.create(company);
        return ResponseEntity.created(URI.create("/api/company" + created.getId())).build();
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CompanyRequest companyRequest, @PathVariable UUID id) {
        Company company = modelMapper.map(companyRequest, Company.class);
        Company existed = companyService.readById(id);
        company.setAnnouncements(existed.getAnnouncements());
        company.setId(id);
        companyService.update(company);
    }

    @GetMapping("/names")
    public List<CompanyName> getAllNames() {
        return companyService.getAllNames();
    }
}
