package ac.su.kdt.productmgmtspring.repository;

import ac.su.kdt.productmgmtspring.domain.constant.ProductStatus;
import ac.su.kdt.productmgmtspring.domain.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("상품 등록 테스트")
    public void create() {
        // 아래는 테스트 로직을 직접 작성한 방식
        // 상품 생성 후 적절한 더미 데이터 생성 후 저장
        Product product = new Product();
        product.setName("테스트 상품");
        product.setPrice(1000);
        product.setStockCount(100);
        product.setStatus(ProductStatus.IN_STOCK);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        Product savedProduct = productRepository.save(product);
        System.out.println(savedProduct);

        // 간이 TDD -> 진짜 TDD 로 바꾸기
        // 1) 실패하는 테스트를 메인 로직상의 메서드 호출 방식으로 수행
        // 2) 메인 로직을 작성
        // 3) 테스트가 성공하는지 확인
    }

    // 상품 등록 상태에 따른 케이스 테스트 TDD
    // Given- When- Then 패턴
    // Given : 테스트를 위한 데이터 준비
    // When : 테스트를 위한 메서드 호출
    // Then : 결과 검증
    @Test
    @DisplayName("상품 리스트 등록 테스트")
    public void createList() {
        List<Product> productList = new ArrayList<>();
        // 상품 10 개의 더미 데이터 생성 후 저장
        for (int i = 1; i <= 10; i++) {
            Product product = new Product();
            product.setName("테스트 상품 " + i);
            product.setPrice(1000 * i);
            product.setStockCount(100 * i);
            // 상품 상태를 랜덤 설정
            if (Math.random() < 0.5) {
                // 50% 확률로 상품 상태를 PREPARING 또는 IN_STOCK 으로 설정
                product.setStatus(Math.random() < 0.5 ? ProductStatus.PREPARING : ProductStatus.IN_STOCK);
            } else {
                // 50% 확률로 상품 상태를 SOLD_OUT 또는 DELETED 으로 설정
                product.setStatus(Math.random() < 0.5 ? ProductStatus.SOLD_OUT : ProductStatus.DELETED);
            }
            product.setCreatedAt(LocalDateTime.now());
            product.setUpdatedAt(LocalDateTime.now());
            productList.add(product);
        }
        // 상품 리스트 저장 및 확인
        List<Product> savedProductList = productRepository.saveAll(productList);
        savedProductList.forEach(System.out::println);
    }

    public void createListStatusFix() {
        List<Product> productList = new ArrayList<>();
        // 상품 10 개의 더미 데이터 생성 후 저장
        for (int i = 1; i <= 10; i++) {
            Product product = new Product();
            product.setName("테스트 상품 " + i);
            product.setPrice(1000 * i);
            product.setStockCount(100 * i);
            // 상품 상태를 랜덤 설정
            if (i <= 3) {
                // 50% 확률로 상품 상태를 PREPARING 또는 IN_STOCK 으로 설정
                product.setStatus(ProductStatus.PREPARING);
            } else {
                // 50% 확률로 상품 상태를 SOLD_OUT 또는 DELETED 으로 설정
                product.setStatus(Math.random() < 0.5 ? ProductStatus.SOLD_OUT : ProductStatus.DELETED);
            }
            product.setCreatedAt(LocalDateTime.now());
            product.setUpdatedAt(LocalDateTime.now());
            productList.add(product);
        }
        // 상품 리스트 저장 및 확인
        List<Product> savedProductList = productRepository.saveAll(productList);
        savedProductList.forEach(System.out::println);
    }

    // 1) 상품 이름 단일 필터링
    @Test
    @DisplayName("상품 이름으로 조회 테스트")
    public void findByNameTest() {
        // 상품 10 개의 더미 데이터 생성 후 저장
        createList();  // given
        // 상품 이름으로 상품 리스트 조회
        List<Product> productList = productRepository.findByName("테스트 상품 5");  // when

        // 출력 결과를 눈으로 확인하는 테스트 (테스트 자동화 불가)
        productList.forEach(System.out::println);  // then
        // then 을 assertEquals 로 바꾸기 (테스트 자동화 가능)
        assertEquals(1, productList.size());
        assertEquals("테스트 상품 5", productList.get(0).getName());
    }

    // TDD 고도화 가이드
    // 1) 더미 데이터 케이스 상세화
    //  - 실제 발생할 수 있는 유저 입력 사례 반영
    // 2) assertion 케이스 상세화
    //  - 엣지 케이스 (경계값) 테스트 (데이터 타입, 최대 최소값, 데이터 길이, null 여부 등)
    //  - 데이터 간 상호작용 테스트 (재고가 없는 상품 구매 시도 등)

    // 2) 상품 상태 단일 필터링
    @Test
    @DisplayName("상품 상태로 조회 테스트")
    public void findByStatusTest() {
        // 상품 10 개의 더미 데이터 생성 후 저장
        createListStatusFix();

        // 상품 이름으로 상품 리스트 조회
        List<Product> productList = productRepository.findByStatus(ProductStatus.PREPARING);
        productList.forEach(System.out::println);

        // 상품 상태가 PREPARING 인 상품이 3개 이상인지 확인
        assertTrue(productList.size() >= 3, "상품 상태가 PREPARING 인 상품이 3개 이상입니다.");
    }

    @Test
    @DisplayName("상품 가격 범위 조회 테스트")
    void findByPriceBetween() {
        // 상품 10 개의 더미 데이터 생성 후 저장
        createList();

        // 상품 가격 범위로 상품 리스트 조회
        List<Product> productList = productRepository.findByPriceBetween(1000, 5000);
        productList.forEach(System.out::println);

        // 상품 가격이 1000 이상 5000 이하인 상품이 5개 이상인지 확인
        assertEquals(5, productList.size(), "상품 가격이 1000 이상 5000 이하인 상품이 5개 이상입니다.");
    }

    // 3) 상품 재고 상태 필터링
    @Test
    @DisplayName("유효 상품 조회 테스트 1")
    public void readValidProducts() {
        // 상품 10 개의 더미 데이터 생성 후 저장
        createList();

        // 상품 상태가 PREPARING, IN_STOCK 인 상품 리스트 조회
        List<Product> inStockProductList = productRepository.findByStatusList(List.of(ProductStatus.PREPARING, ProductStatus.IN_STOCK));

        // then 절에서 시각적 확인만 수행 (자동화 불가)
        inStockProductList.forEach(System.out::println);
        // TODO : assert 직접 작성하기!
    }
}