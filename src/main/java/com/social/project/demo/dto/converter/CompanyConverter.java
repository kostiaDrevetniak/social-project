package com.social.project.demo.dto.converter;

import com.social.project.demo.model.Company;
import com.social.project.demo.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CompanyConverter extends AbstractConverter<UUID, Company> {
    private final CompanyService companyService;

    @Override
    protected Company convert(UUID companyId) {
        return companyService.readById(companyId);
    }
}
