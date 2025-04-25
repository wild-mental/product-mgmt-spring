package ac.su.kdt.productmgmtspring.controller;

import ac.su.kdt.productmgmtspring.domain.dto.ProductRequestDTO;
import ac.su.kdt.productmgmtspring.domain.dto.ProductResponseDTO;
import ac.su.kdt.productmgmtspring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    // 상품 등록
    @PostMapping
    public ProductResponseDTO create(
        @RequestBody ProductRequestDTO productRequestDTO
    ) {
        // 상품 등록 로직
        return productService.create(productRequestDTO);
    }
}
