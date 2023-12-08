package com.social.project.demo.dto;

import lombok.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MapWrapper {
    private Map<String, String> categories = new HashMap<>();
}
