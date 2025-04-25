package ac.su.kdt.productmgmtspring.repository;

import ac.su.kdt.productmgmtspring.domain.constant.ProductStatus;
import ac.su.kdt.productmgmtspring.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>,
    QuerydslPredicateExecutor<Product>  // 인터페이스 다중구현 방식으로 라이브러리 추가하기
{
    List<Product> findByName(String name);

    // 상품 상태로 상품 조회
    List<Product> findByStatus(ProductStatus status);

    // 가격 구간으로 상품 조회
    List<Product> findByPriceBetween(int min, int max);

    @Query("SELECT p FROM Product p WHERE p.status IN :statusList")
    List<Product> findByStatusList(@Param("statusList") List<ProductStatus> statusList);

    @Query(  // Java/Spring 실행 컨텍스트 외부에 존재하는 코드 구문이 포함되는 경우
             // 컴파일 타임에 오류를 체크할 수 없으므로 주의해야 함!
        value = "SELECT * FROM product WHERE status in :statusList",
        nativeQuery = true
    )
    List<Product> findByStatusListNative(@Param("statusList") List<ProductStatus> statusList);
}