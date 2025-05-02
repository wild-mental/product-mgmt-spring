package ac.su.kdt.productmgmtspring.controller;

import ac.su.kdt.productmgmtspring.domain.dto.ProductRequestDTO;
import ac.su.kdt.productmgmtspring.domain.dto.ProductResponseDTO;
import ac.su.kdt.productmgmtspring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    // CREATE 상품 등록
    @PostMapping
    public ProductResponseDTO create(
        @RequestBody ProductRequestDTO productRequestDTO
    ) {
        // 상품 등록 로직
        return productService.create(productRequestDTO);
    }
    // READ 상품 조회
    // 1) 상품 전체 조회 (전체 리스트)
    @GetMapping("/all")
    public List<ProductResponseDTO> readAll() {
        // 상품 전체 조회 로직
        return productService.readAll();
    }
    // 2) 상품 전체 조회 (페이징 처리)
    @GetMapping
    public Page<ProductResponseDTO> readPage() {
        // 상품 전체 조회 로직
        return productService.readPage();
    }

    // 3) 상품 단건 조회
    @GetMapping("/{id}")
    public ProductResponseDTO readOne(
        @PathVariable Long id
    ) {
        // 상품 단건 조회 로직
        return productService.readOne(id);
    }

    // UPDATE 상품 수정
    @PutMapping("/{id}")
    public ProductResponseDTO put(
        @PathVariable Long id,
        @RequestBody ProductRequestDTO productRequestDTO
    ) {
        // 상품 수정 로직
        return productService.put(id, productRequestDTO);
    }
    // PATCH 상품 수정
    @PatchMapping("/{id}")
    public ProductResponseDTO patch(
        @PathVariable Long id,
        // 데이터 수정 포인트가 줄어들지만, Request 에서 수신한 필드별 검사가 필요함
        @RequestBody ProductRequestDTO productRequestDTO
    ) {
        // 상품 수정 로직
        return productService.patch(id, productRequestDTO);
    }

    // DELETE 상품 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
        @PathVariable Long id
    ) {
        // 상품 삭제 실패 케이스에 대한 상세 핸들링 및 응답 메시지 처리
        if (productService.delete(id)) {
            return ResponseEntity.ok()
                .body("상품 삭제에 성공했습니다.");
        } else {
            // TODO : 예외 처리
            return ResponseEntity.badRequest()
                .body("상품 삭제에 실패했습니다.");
        }
    }

}
