package ac.su.kdt.productmgmtspring.domain.dto;

import ac.su.kdt.productmgmtspring.domain.constant.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ProductRequestDTO {
    private final Long id;
    private final String name;
    private final int price;  // 특정한 값으로 오버라이딩 되지 않은 경우 -1로 초기화
    private final int stockCount;  // 특정한 값으로 오버라이딩 되지 않은 경우 -1로 초기화
    private final ProductStatus status;

    public ProductRequestDTO(Long id, String name, Integer price, Integer stockCount, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.price = price == null ? -1 : price;
        this.stockCount = stockCount == null ? -1 : stockCount;
        this.status = status;
    }
}
