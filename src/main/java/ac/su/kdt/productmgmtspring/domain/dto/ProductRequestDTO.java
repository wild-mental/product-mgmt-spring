package ac.su.kdt.productmgmtspring.domain.dto;

import ac.su.kdt.productmgmtspring.domain.constant.ProductStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductRequestDTO {
    private Long id;
    private String name;
    private int price;
    private int stockCount;
    private ProductStatus status;
}
