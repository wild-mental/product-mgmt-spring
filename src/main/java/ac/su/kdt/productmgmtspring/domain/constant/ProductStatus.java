package ac.su.kdt.productmgmtspring.domain.constant;

public enum ProductStatus {
    // 비즈니스 로직과 연결해서 적절한 상태값을
    // 상태의 유형별 분류와 함께 계획하기

    // 1) 판매 상태
    PREPARING,  // PREPARING("판매 준비 중"),
    IN_STOCK,
    SOLD_OUT,
    // 2) 데이터 상태
    INVALID,
    DELETED;

    // Constructor with a string value
//    private String value;
//    ProductStatus(String s) {
//        this.value = s;
//    }
}