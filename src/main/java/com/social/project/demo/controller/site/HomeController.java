package com.social.project.demo.controller.site;

import com.social.project.demo.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final CompanyService companyService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("sponsorLogos", companyService.getSponsorsLogo());
        List<String> partnersLogo = companyService.getPartnersLogo();
        int fullChunks = partnersLogo.size() / 3;
        List<List<String>> logosBy3 = new ArrayList<>();
        for (int i = 0; i < fullChunks; ++i) {
            logosBy3.add(List.of(partnersLogo.remove(0), partnersLogo.remove(0), partnersLogo.remove(0)));
        }
        int remainder = partnersLogo.size() % 3;
        if (remainder > 0) {
            List<String> tempList = new ArrayList<>();
            for (int i = 0; i < remainder; ++i) {
                tempList.add(partnersLogo.remove(0));
            }
            logosBy3.add(tempList);
        }
        model.addAttribute("partnersLogo", logosBy3);
        return "/index";

    }

}
