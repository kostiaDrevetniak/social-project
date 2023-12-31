package com.social.project.demo.service.impl;

import com.social.project.demo.dto.response.CompanyName;
import com.social.project.demo.model.Company;
import com.social.project.demo.repository.CompanyRepository;
import com.social.project.demo.service.CompanyService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public Company create(Company company) {
        if (company == null)
            throw new IllegalArgumentException("Company cannot be 'null'");
        return companyRepository.save(company);
    }

    @Override
    public Company readById(UUID id) {
        return companyRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Company with id " + id + " not found"));
    }

    @Override
    public Company update(Company company) {
        if (company == null)
            throw new IllegalArgumentException("Company cannot be 'null'");
        readById(company.getId());
        return companyRepository.save(company);
    }

    @Override
    public void delete(UUID id) {
        Company company = readById(id);
        companyRepository.delete(company);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public List<CompanyName> getAllNames() {
        return companyRepository.getAllCompaniesName();
    }

    @Override
    public Company getByChannelName(String channelName) {
        return companyRepository.getByChannelName(channelName);
    }

    @Override
    public List<String> getSponsorsLogo() {
        List<byte[]> sponsorsLogo = companyRepository.getSponsorsLogo();
        return sponsorsLogo.stream().map(s -> Base64.getEncoder().encodeToString(s)).toList();
    }

    @Override
    public List<String> getPartnersLogo() {
        List<byte[]> sponsorsLogo = companyRepository.getPartnersLogo();
        return sponsorsLogo.stream().map(s -> Base64.getEncoder().encodeToString(s))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<Company> getSponsors() {
        return companyRepository.getSponsors();
    }

    @Override
    public List<Company> getPartners() {
        return companyRepository.getPartners();
    }
}
