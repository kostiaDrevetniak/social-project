package com.social.project.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    @JsonProperty("value")
    private UUID id;
    @JsonProperty("label")
    private String name;
}
