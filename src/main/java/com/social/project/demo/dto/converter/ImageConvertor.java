package com.social.project.demo.dto.converter;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class ImageConvertor extends AbstractConverter<byte[], String> {
    @Override
    protected String convert(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
}
