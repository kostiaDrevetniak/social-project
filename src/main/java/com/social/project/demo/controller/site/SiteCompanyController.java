package com.social.project.demo.controller.site;

import com.social.project.demo.dto.response.PartnerResponse;
import com.social.project.demo.dto.response.SponsorResponse;
import com.social.project.demo.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class SiteCompanyController {

    private final CompanyService companyService;
    private final ModelMapper modelMapper;

    @GetMapping("/partners")
    public String allPartners(Model model) {
        model.addAttribute("partners", companyService.getPartners().stream()
                .map(partner -> modelMapper.map(partner, PartnerResponse.class)).toList());
        return "/partner-list";
    }

    @GetMapping("/sponsors")
    public String allSponsors(Model model) {
        model.addAttribute("sponsors", companyService.getSponsors().stream()
                .map(sponsor -> modelMapper.map(sponsor, SponsorResponse.class)).toList());
        return "/sponsor-list";
    }
}
