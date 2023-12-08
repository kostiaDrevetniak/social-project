package com.social.project.demo.dto.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class PartnerResponse {
    private UUID id;
    private String name;
    private String description;
    private String logo;
}
