# ERD 설계

```mermaid
---
title: E-Commerce ER Diagram
config:
    look: handDrawn
    theme: neutral
---
erDiagram
    user ||--o| balance : has
    user ||--o{ issued_coupon : has
    user ||--o{ order : has

    coupon ||--o{ issued_coupon : has
    coupon ||--|| coupon_policy : has
    coupon ||--o{ coupon_stock : has
        
    order ||--o| issued_coupon : has
    order ||--o| payment : has
    order ||--o{ order_item : contains
    
    order_item }o--|| item : references
    item ||--o{ item_stock : has

    order {
        bigint id PK "주문 ID"
        bigint user_id FK "사용자 ID"
        bigint issued_coupon_id FK "발급 쿠폰 ID"
        varchar order_status "주문 상태 (주문 생성 / 결제 완료 / 주문 취소)"
        timestamp created_at "생성 일시"
        timestamp updated_at "수정 일시"
    }

    user {
        bigint id PK "사용자 ID"
        timestamp created_at "생성 일시"
        timestamp updated_at "수정 일시"
    }

    payment {
        bigint id PK "결제 ID"
        bigint order_id FK "주문 ID"
        int price "결제 금액"
        varchar payment_method "결제 수단"
        varchar payment_status "결제 상태 (결제 완료 / 결제 취소)"
        timestamp created_at "생성 일시"
        timestamp updated_at "수정 일시"
    }

    order_item {
        bigint id PK "주문 상품 ID"
        bigint order_id FK "주문 ID"
        bigint item_id FK "상품 ID"
        varchar name "주문 상품명"
        int unit_price "상품 단가 금액"
        int quantity "상품 수량"
    }

    item {
        bigint id PK "상품 ID"
        varchar name "상품명"
        varchar item_status "상품 판매 상태 (판매중 / 판매 중단)"
        timestamp created_at "생성 일시"
        timestamp updated_at "수정 일시"
    }

    item_stock {
        bigint id PK "상품 재고 ID"
        bigint item_id FK "상품 ID"
        int quantity "수량"
        timestamp created_at "생성 일시"
        timestamp updated_at "수정 일시"
    }

    balance {
        bigint id PK "포인트 ID"
        bigint user_id FK, UK "사용자 ID"
        int amount "잔액"
        timestamp created_at "생성 일시"
        timestamp updated_at "수정 일시"
    }

    coupon {
        bigint id PK "쿠폰 ID"
        varchar name "쿠폰명"
        timestamp use_start_at "쿠폰 사용 시작 시각"
        timestamp use_end_at "쿠폰 사용 종료 시각"
        timestamp issue_start_at "쿠폰 발급 시작 시각"
        timestamp issue_end_at "쿠폰 발급 종료 시각"
        timestamp created_at "생성 일시"
        timestamp updated_at "수정 일시"
    }
    
    coupon_policy {
        bigint id PK "쿠폰 정책 ID"
        bigint coupon_id FK "쿠폰 ID"
        varchar discount_type "할인 정책 (정액 / 정률)"
        varchar discount_value "할인 금액 / 비율"
        int min_pay_amount "쿠폰 적용 가능 최소 주문 금액"
        int max_discount_amount "쿠폰 적용 최대 할인 금액"
        int is_duplicate_allowed "쿠폰 중복 발급 가능 여부"
    }

    coupon_stock {
        bigint id PK "쿠폰 수량 ID"
        bigint coupon_id FK "쿠폰 ID"
        int quantity "수량"
        timestamp created_at "생성 일시"
        timestamp updated_at "수정 일시"
    }

    issued_coupon {
        bigint id PK "발급 쿠폰 ID"
        bigint coupon_id FK "쿠폰 ID"
        bigint user_id FK "사용자 ID"
        boolean is_used "사용 여부"
        timestamp created_at "생성 일시"
        timestamp updated_at "수정 일시"
    }
```

## 상태 및 타입 정의 (Status & Type)

### 주문 상태 (order_status)
#### 주문 테이블 (order)

|   Type   | Description |
|:--------:|:-----------:|
| CREATED  |    주문 생성    |
|   PAID   |    결제 완료    |
| CANCELED |    주문 취소    |

### 결제 상태 (payment_status)
#### 결제 테이블 (payment)

|   Type    | Description |
|:---------:|:-----------:|
| COMPLETED |    결제 완료    |
| CANCELED  |    결제 취소    |

### 결제 수단 (method)
#### 결제 테이블 (payment)

| Type  | Description |
|:-----:|:---------:|
| CARD  |     카드    |
| CASH  |     현금    |
| KAKAO |    카카오페이  |
| NAVER |    네이버페이  |
| TOSS  |    토스페이   |

### 상품 상태 (item_status)
#### 상품 테이블 (item)

|  Type   | Description |
|:-------:|:-----------:|
| SELLING |     판매중     |
| STOPPED |    판매 중단    |

### 쿠폰 할인 정책 (discount_type)
#### 쿠폰 정책 테이블 (coupon_policy)

| Type  | Description |
|:-----:|:-----------:|
| FIXED |     정액      |
| RATE  |     정률      |