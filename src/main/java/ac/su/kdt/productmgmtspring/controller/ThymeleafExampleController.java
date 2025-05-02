package ac.su.kdt.productmgmtspring.controller;

import ac.su.kdt.productmgmtspring.domain.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafExampleController {
    //   1. ThymeLeaf 의존성 추가
    //   2. resources/templates/thymeleaf/ex01.html 파일 생성
    //     - 생성한 파일을 렌더링 없이 확인
    //   3. ThymeLeaf 템플릿 엔진을 사용하기 위한 컨트롤러 생성
    //   4. http://localhost:8080/thmeleaf/ex01 주소로 접속해 템플릿 렌더링 확인
    //   5. 템플릿 수신 데이터 추가 및 model 데이터 수정에 따른 렌더링 재확인
    @GetMapping("/ex01")
    public String ex01(Model model) {
        // data 전달
        model.addAttribute("data", "Hello, ThymeLeaf from Controller! (SSR response)");
        return "thymeleaf/ex01";
    }
    @GetMapping("/ex02")
    public String ex02(Model model) {
        // data 전달
        model.addAttribute("data1", "Hello, ThymeLeaf from Controller! (SSR response) 1");
        model.addAttribute("data2", "Hello, ThymeLeaf from Controller! (SSR response) 2");
        model.addAttribute("data3", "Hello, ThymeLeaf from Controller! (SSR response) 3");
        return "thymeleaf/ex02";
    }

    @GetMapping("/ex03")
    public String ex03(Model model) {
        // data 전달
        model.addAttribute("obj1", List.of(1, 2, 3));
        Product product = new Product();
        product.setName("this is sample product");
        product.setPrice(1000);
        model.addAttribute("obj2", product);
        model.addAttribute("obj3", ThymeleafExampleController.this);
        return "thymeleaf/ex03";
    }
}