package com.social.project.demo.service;

import com.social.project.demo.dto.response.CompanyName;
import com.social.project.demo.model.Company;

import java.util.List;
import java.util.UUID;

public interface CompanyService {
    Company create(Company company);
    Company readById(UUID id);
    Company update(Company company);
    void delete(UUID id);
    List<Company> getAll();
    List<CompanyName> getAllNames();
    Company getByChannelName(String channelName);
}
