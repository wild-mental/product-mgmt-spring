package ac.su.kdt.productmgmtspring.service;

import ac.su.kdt.productmgmtspring.domain.constant.ProductStatus;
import ac.su.kdt.productmgmtspring.domain.dto.ProductRequestDTO;
import ac.su.kdt.productmgmtspring.domain.dto.ProductResponseDTO;
import ac.su.kdt.productmgmtspring.domain.entity.Product;
import ac.su.kdt.productmgmtspring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<ProductResponseDTO> readAll() {
        return null;
    }

    public Page<ProductResponseDTO> readPage() {
        return null;
    }

    public ProductResponseDTO readOne(Long id) {
        return null;
    }

    public ProductResponseDTO put(Long id, ProductRequestDTO productRequestDTO) {
        return null;
    }

    public ProductResponseDTO patch(Long id, ProductRequestDTO productRequestDTO) {
        return null;
    }

    public boolean delete(Long id) {
        return false;
    }
}
