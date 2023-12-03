package com.social.project.demo.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CompanyResponse {
    private String name;
    private String description;
    private String channelName;
    private byte[] logo;
    private String type;
}
