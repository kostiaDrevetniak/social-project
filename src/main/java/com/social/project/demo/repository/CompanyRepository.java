package com.social.project.demo.repository;

import com.social.project.demo.dto.response.CompanyName;
import com.social.project.demo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    @Query("Select new com.social.project.demo.dto.response.CompanyName(company.id, company.name) from Company company")
    List<CompanyName> getAllCompaniesName();

    Company getByChannelName(String channelName);
}
