package ac.su.kdt.productmgmtspring.domain.dto;

import ac.su.kdt.productmgmtspring.domain.constant.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductRequestDTO {
    private Long id;
    private String name;
    private int price;
    private int stockCount;
    private ProductStatus status;
}
