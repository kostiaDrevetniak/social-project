package com.social.project.demo.config;

import com.social.project.demo.dto.converter.CompanyConverter;
import com.social.project.demo.dto.converter.ImageConvertor;
import com.social.project.demo.dto.request.AnnouncementRequest;
import com.social.project.demo.model.Announcement;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(CompanyConverter companyConverter, ImageConvertor imageConvertor) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(companyConverter);
        modelMapper.addConverter(imageConvertor);
        modelMapper.typeMap(AnnouncementRequest.class, Announcement.class)
                .addMappings(mp -> mp.skip(Announcement::setId));
        return modelMapper;
    }
}
