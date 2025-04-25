package ac.su.kdt.productmgmtspring.domain.dto;

import ac.su.kdt.productmgmtspring.domain.constant.ProductStatus;
import ac.su.kdt.productmgmtspring.domain.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String name;
    private int price;
    private int stockCount;
    private ProductStatus status;

    // 등록 및 수정 시각
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductResponseDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.stockCount = product.getStockCount();
        this.status = product.getStatus();
        this.createdAt = product.getCreatedAt();
        this.updatedAt = product.getUpdatedAt();
    }

    public static ProductResponseDTO fromEntity(Product product) {
        return new ProductResponseDTO(product);
    }
}
