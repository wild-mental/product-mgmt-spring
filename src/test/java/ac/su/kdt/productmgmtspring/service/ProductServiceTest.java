package ac.su.kdt.productmgmtspring.service;

import ac.su.kdt.productmgmtspring.domain.constant.ProductStatus;
import ac.su.kdt.productmgmtspring.domain.dto.ProductRequestDTO;
import ac.su.kdt.productmgmtspring.domain.dto.ProductResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ProductServiceTest {
    private ProductService productService;

    @Autowired
    public ProductServiceTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
    void create() {
        ProductResponseDTO createdProductDTO = productService.create(
            // 테스트용 더미 데이터 (mocking)
            // -> 테스트에 필요한 주요 케이스들을 상세하게 정의한 경우 (타입 / 범위 / 값)
            new ProductRequestDTO(
                null,
                "테스트 상품 mocking",
                1000,
                100,
                ProductStatus.IN_STOCK
            )
            // 포켓몬 게임 개발할 때 더미데이터, Fixture 데이터, Mock 데이터
        );
        // assert 로직 추가
        // 상품 등록 후 반환된 DTO 확인
        System.out.println(createdProductDTO);
        assertNotNull(createdProductDTO);
    }
}