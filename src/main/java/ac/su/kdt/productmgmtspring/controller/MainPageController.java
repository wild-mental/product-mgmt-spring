package ac.su.kdt.productmgmtspring.controller;

import ac.su.kdt.productmgmtspring.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainPageController {
    private final MainPageService mainPageService;

    @GetMapping
    public String mainPage() {
        return "index";
    }
}
