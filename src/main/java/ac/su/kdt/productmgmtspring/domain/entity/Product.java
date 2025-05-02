package ac.su.kdt.productmgmtspring.domain.entity;

import ac.su.kdt.productmgmtspring.domain.constant.ProductStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter @Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int stockCount;
    @Column(nullable = false)
    private ProductStatus status;

    // 등록 및 수정 시각
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // prePersist, preUpdate
    // 기본값 처리 + @ 로 사용할 수 있다
    // 유효성 검사 및 데이터 전처리 (Formatting, 길이 조정 등)도 가능
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // toString 오버라이딩을 통해 자동 JSON 타입 변환 시 순환 참조 출력 문제 해결 필요
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockCount=" + stockCount +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                // 참조 필드는 객체를 그대로 출력하지 않고 데이터를 추출해서 쓰거나 id 값만 출력
                '}';
    }
}