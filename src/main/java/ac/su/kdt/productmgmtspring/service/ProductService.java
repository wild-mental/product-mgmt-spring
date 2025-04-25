package ac.su.kdt.productmgmtspring.service;

import ac.su.kdt.productmgmtspring.domain.constant.ProductStatus;
import ac.su.kdt.productmgmtspring.domain.dto.ProductRequestDTO;
import ac.su.kdt.productmgmtspring.domain.dto.ProductResponseDTO;
import ac.su.kdt.productmgmtspring.domain.entity.Product;
import ac.su.kdt.productmgmtspring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponseDTO create(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setPrice(productRequestDTO.getPrice());
        product.setStockCount(productRequestDTO.getStockCount());
        product.setStatus(productRequestDTO.getStatus());
        Product savedProduct = productRepository.save(product);
        return ProductResponseDTO.fromEntity(savedProduct);
    }
}
