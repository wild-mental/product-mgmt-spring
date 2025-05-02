package ac.su.kdt.productmgmtspring.service;

import ac.su.kdt.productmgmtspring.domain.constant.ProductStatus;
import ac.su.kdt.productmgmtspring.domain.dto.ProductRequestDTO;
import ac.su.kdt.productmgmtspring.domain.dto.ProductResponseDTO;
import ac.su.kdt.productmgmtspring.domain.entity.Product;
import ac.su.kdt.productmgmtspring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        // Repository 호출 및 DTO 변환
//        List<Product> products = productRepository.findAll();
//        return products.stream()
//                .map(ProductResponseDTO::fromEntity)
//                .toList();
        return productRepository.findAll().stream().map(ProductResponseDTO::fromEntity).toList();
    }

    public Page<ProductResponseDTO> readPage(
            PageRequest pageRequest
    ) {
        // Repository 호출 및 DTO 변환
        // Page 타입에서는 명시적 Stream 처리 불필요
        return productRepository.findAll(pageRequest).map(ProductResponseDTO::fromEntity);
    }

    public ProductResponseDTO readOne(Long id) {
        Optional<Product> product = productRepository.findById(id);
        // 무효 케이스를 먼저 처리하는 패턴
//        if (product.isEmpty()) {
//            // 추가 로직 구현 1
//            return null;
//        } else {
//            // 추가 로직 구현 2
//            return ProductResponseDTO.fromEntity(product.get());
//        }
        return product.map(ProductResponseDTO::fromEntity).orElse(null);
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
