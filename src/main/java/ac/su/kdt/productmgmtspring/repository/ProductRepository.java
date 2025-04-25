package ac.su.kdt.productmgmtspring.repository;

import ac.su.kdt.productmgmtspring.domain.constant.ProductStatus;
import ac.su.kdt.productmgmtspring.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);

    // 상품 상태로 상품 조회
    List<Product> findByStatus(ProductStatus status);

    // 가격 구간으로 상품 조회
    List<Product> findByPriceBetween(int min, int max);

    @Query("SELECT p FROM Product p WHERE p.status IN :statusList")
    List<Product> findByStatusList(@Param("statusList") List<ProductStatus> statusList);
}