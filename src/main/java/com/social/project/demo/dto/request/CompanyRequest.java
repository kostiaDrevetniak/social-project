package com.social.project.demo.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CompanyRequest {
    private String name;
    private String description;
    private String channelName;
    private byte[] logo;
    private String type;
}
