# API 명세

1. [상품 목록 조회](#상품-목록-조회)
2. [인기 상품 조회](#인기-상품-조회)
3. [쿠폰 발급](#쿠폰-발급)
4. [보유 쿠폰 목록 조회](#보유-쿠폰-목록-조회)
5. [주문](#주문-생성)
6. [결제](#결제-진행)
7. [잔액 조회](#잔액-조회)
8. [잔액 충전](#잔액-충전)

---

## 상품 API

### 상품 목록 조회

#### [Description]
상품 목록을 조회한다.   

#### [Request]
```http request
GET /api/v1/items
Accept: application/json
```

#### [Response]
- Response Body

```json
// 200 OK
{
  "code": 200,
  "message": "OK",
  "errorMessage": null,
  "data": {
    "content": [
      {
        "id": 1,
        "name": "상품명",
        "price": 300000,
        "status": "SELLING",
        "stock": 3
      }
    ],
    "pagination": {
      "currentPage": 1,
      "countPerPage": 10,
      "totalPages": 1,
      "totalElements": 3
    }
  }
}
```

- Response Fields

| Path                          | Type   | Description     |
|-------------------------------|--------|-----------------|
| code                          | Number | 응답 코드           |
| message                       | String | 응답 메세지          |
| errorMessage                  | null   | 실패 이유           |
| data                          | Object | 결과 데이터          |
| data.content[]                | Array  | 상품 목록 조회 결과 데이터 |
| data.content[].id             | Number | 상품 ID           |
| data.content[].name           | String | 상품명             |
| data.content[].price          | Number | 상품 가격           |
| data.content[].status         | Number | 상품 판매 상태     |
| data.content[].stock          | Number | 상품 재고           |
| data.pagination               | Object | 페이징             |
| data.pagination.countPerPage  | Number | 페이지 별 데이터 Count |
| data.pagination.currentPage   | Number | 현재 페이지          |
| data.pagination.totalPage     | Number | 전체 페이지 Count    |
| data.pagination.totalElements | Number | 전체 데이터 Count    |


<br> 

--- 

### 인기 상품 조회

#### [Description]
최근 3일간 상위 상품 Top 5 조회.   

#### [Request]
```http request
GET /api/v1/products/popular
Accept: application/json
```

#### [Response]
- Response Body

```json
// 200 OK
{
  "code": 200,
  "message": "OK",
  "errorMessage": null,
  "data": {
    "content": [
      {
        "id": 1,
        "name": "상품명",
        "price": 300000,
        "status": "SELLING",
        "saleCount": 3,
        "stock": 3
      }
    ],
    "pagination": {
      "currentPage": 1,
      "countPerPage": 10,
      "totalPages": 1,
      "totalElements": 3
    }
  }
}
```

- Response Fields

| Path                          | Type   | Description     |
|-------------------------------|--------|-----------------|
| code                          | Number | 응답 코드           |
| message                       | String | 응답 메세지          |
| errorMessage                  | null   | 실패 이유           |
| data                          | Object | 결과 데이터          |
| data.content[]                | Array  | 상위 상품 조회 결과 데이터 |
| data.content[].id             | Number | 상품 ID           |
| data.content[].name           | String | 상품명             |
| data.content[].price          | Number | 상품 가격           |
| data.content[].status         | Number | 상품 판매 상태     |
| data.content[].saleCount      | Number | 상품 판매 수         |
| data.content[].stock          | Number | 상품 재고           |
| data.pagination               | Object | 페이징             |
| data.pagination.countPerPage  | Number | 페이지 별 데이터 Count |
| data.pagination.currentPage   | Number | 현재 페이지          |
| data.pagination.totalPage     | Number | 전체 페이지 Count    |
| data.pagination.totalElements | Number | 전체 데이터 Count    |

<br>

---

## 쿠폰 API

### 보유 쿠폰 목록 조회

#### [Description]
사용 가능한 보유 쿠폰 목록을 조회한다.   

#### [Request]
```http request
GET /api/v1/users/{userId}/coupons
Accept: application/json
```
- Path Variable

| Parameter | Description |
|-----------|-------------|
| userId    | 사용자 ID    |

#### [Response]

- Response Body

```json
// 200 OK
{
  "code": 200,
  "message": "OK",
  "errorMessage": null,
  "data": {
    "content": [
      {
        "id": 1,
        "name": "쿠폰명",
        "discountType": "FIXED",
        "discountAmount": 2000,
        "minPayAmount": 10000,
        "maxDiscountAmount": 2000,
        "isUsed": false,
        "useStartAt": "2026-01-01T09:00:00",
        "useEndAt": "2026-01-01T09:00:00",
        "createdAt": "2025-01-01T09:00:00"
      }
    ],
    "pagination": {
      "currentPage": 1,
      "countPerPage": 10,
      "totalPages": 1,
      "totalElements": 3
    }
  }
}
```

- Response Fields

| Path                             | Type    | Description     |
|----------------------------------|---------|-----------------|
| code                             | Number  | 응답 코드           |
| message                          | String  | 응답 메세지          |
| errorMessage                     | null    | 실패 이유           |
| data                             | Object  | 결과 데이터          |
| data.content[]                   | Array   | 발급 쿠폰 조회 결과 데이터 |
| data.content[].id                | Number  | 발급 쿠폰 ID        |
| data.content[].name              | String  | 쿠폰명             |
| data.content[].discountType      | String  | 할인 정책           |
| data.content[].discountAmount    | Number  | 할인 금액 / 비율      |
| data.content[].minPayAmount      | Number  | 최소 주문 금액        | 
| data.content[].maxDiscountAmount | Number  | 최대 할인 금액        |
| data.content[].isUsed            | Boolean | 사용 여부           |
| data.content[].useStartAt        | String  | 쿠폰 사용 시작 시각     |
| data.content[].useEndAt          | String  | 쿠폰 사용 종료 시각     |
| data.content[].createdAt         | String  | 발급 일시           |
| data.pagination                  | Object  | 페이징             |
| data.pagination.countPerPage     | Number  | 페이지 별 데이터 Count |
| data.pagination.currentPage      | Number  | 현재 페이지          |
| data.pagination.totalPage        | Number  | 전체 페이지 Count    |
| data.pagination.totalElements    | Number  | 전체 데이터 Count    |

<br>

#### [Error Spec]
| HTTP CODE | MESSAGE                  | SOLUTION                  |
|-----------|--------------------------|---------------------------|
| 400       | 유효하지 않은 사용자 ID 입니다.      | 올바른 사용자 ID를 입력하였는지 확인합니다. |

<br>

---

### 쿠폰 발급

#### [Description]
쿠폰을 발급한다.   

#### [Request]
```http request
POST /api/v1/users/{userId}/coupons
Content-Type: application/json

{
  "couponId": 1
}
```
- Path Variable

| Parameter | Description |
|-----------|-------------|
| userId    | 사용자 ID    |

- Request Fields

| Path     | Type   | Required | Description |
|----------|--------|----------|-------------|
| couponId | Number | true     | 쿠폰 ID     |

<br> 

#### [Response]

- Response Body

```json
// 200 OK
{
  "code": 200,
  "message": "OK",
  "errorMessage": null,
  "data": {
    "content": null,
    "pagination": null
  }
}
```

- Response Fields

| Path                | Type   | Description |
|---------------------|--------|-------------|
| code                | Number | 응답 코드       |
| message             | String | 응답 메세지      |
| errorMessage        | null   | 실패 이유       |
| data                | Object | 결과 데이터      |
| data.content        | null   | 결과 데이터 없음   |
| data.pagination     | null   | 페이징 없음      |

<br>

#### [Error Spec]
| HTTP CODE | MESSAGE                | SOLUTION                  |
|-----------|------------------------|---------------------------|
| 400       | 유효하지 않은 사용자 ID 입니다.    | 올바른 사용자 ID를 입력하였는지 확인합니다. |
| 400       | 발급 가능한 쿠폰이 모두 소진되었습니다. |                           |

<br>

---

## 주문 API

### 주문 생성

#### [Description]
주문을 생성한다.   

#### [Request]
```http request
POST /api/v1/orders
Content-Type: application/json

{
  "userId": 1,
  "issuedCouponId": 2,
  "products": [
    {
      "id": 3,
      "quantity": 2
    }
  ]
}
```

- Request Fields

| Path                | Type   | Required | Description |
|---------------------|--------|----------|-------------|
| userId              | Number | true     | 사용자 ID      |
| issuedCouponId      | Number | false    | 발급 쿠폰 ID    |
| products[].id       | Number | true     | 상품 ID       |
| products[].quantity | Number | true     | 상품 수량       |

<br>

#### [Response]

- Response Body

```json
// 200 OK
{
  "code": 200,
  "message": "OK",
  "errorMessage": null,
  "data": {
    "content": null,
    "pagination": null
  }
}
```

- Response Fields

| Path                | Type   | Description |
|---------------------|--------|-------------|
| code                | Number | 응답 코드       |
| message             | String | 응답 메세지      |
| errorMessage        | null   | 실패 이유       |
| data                | Object | 결과 데이터      |
| data.content        | null   | 결과 데이터 없음   |
| data.pagination     | null   | 페이징 없음      |

<br>

#### [Error Spec]
| HTTP CODE | MESSAGE               | SOLUTION                      |
|-----------|-----------------------|-------------------------------|
| 400       | 유효하지 않은 사용자 ID 입니다.   | 올바른 사용자 ID를 입력하였는지 확인합니다.     |
| 400       | 유효하지 않은 발급 쿠폰 ID 입니다. | 올바른 발급 쿠폰 ID를 입력하였는지 확인합니다.   |
| 400       | 유효하지 않은 상품 ID 입니다.    | 올바른 상품 ID를 입력하였는지 확인합니다.      |
| 400       | 주문 상품을 선택하세요.         | 주문 상품을 선택하였는지 확인합니다.          |
| 400       | 주문 수량을 확인하세요.         | 주문 상품의 수량을 올바르게 선택하였는지 확인합니다. |
| 400       | 쿠폰의 유효기간이 만료되었습니다.    |                               |
| 400       | 상품이 판매 중지 상태입니다.      |                               |
| 400       | 상품이 품절되었습니다.          |                               |

<br>

---

## 결제 API

### 결제 진행

#### [Description]
결제를 진행한다.   

#### [Request]
```http request
POST /api/v1/payments
Content-Type: application/json

{
  "userId": 1,
  "orderId": 1,
  "price": 100000,
  "paymentMethod": "CASH"
}
```

- Request Fields

| Path          | Type   | Required | Description                       |
|---------------|--------|----------|-----------------------------------|
| userId        | Number | true     | 사용자 ID                            |
| orderId       | Number | true     | 주문 ID                             |
| price         | Number | true     | 결제 금액                             |
| paymentMethod | String | true     | 결제 수단(CASH/CARD/KAKAO/NAVER/TOSS) |

<br>

#### [Response]

- Response Body

```json
// 200 OK
{
  "code": 200,
  "message": "OK",
  "errorMessage": null,
  "data": {
    "content": null,
    "pagination": null
  }
}
```

- Response Fields

| Path                | Type   | Description |
|---------------------|--------|-------------|
| code                | Number | 응답 코드       |
| message             | String | 응답 메세지      |
| errorMessage        | null   | 실패 이유       |
| data                | Object | 결과 데이터      |
| data.content        | null   | 결과 데이터 없음   |
| data.pagination     | null   | 페이징 없음      |

<br>

#### [Error Spec]
| HTTP CODE | MESSAGE             | SOLUTION                  |
|-----------|---------------------|---------------------------|
| 400       | 유효하지 않은 사용자 ID 입니다. | 올바른 사용자 ID를 입력하였는지 확인합니다. |
| 400       | 유효하지 않은 주문 ID 입니다.  | 올바른 주문 ID를 입력하였는지 확인합니다.  |
| 400       | 결제 잔액이 부족합니다.       | 잔액 충전 후 결제를 재요청합니다.       |
| 400       | 유효하지 않은 결제 수단입니다.   | 올바른 결제 수단을 입력하였는지 확인합니다.  |

<br>

--- 


## 잔액 API

### 잔액 조회

#### [Description]
사용자 잔액을 조회한다.

#### [Request]
```http request
GET /api/v1/users/{userId}/points
Accept: application/json
```
- Path Variable

| Parameter | Description |
|-----------|-------------|
| userId    | 사용자 ID    |   


#### [Response]

- Response Body

```json
// 200 OK
{
  "code": 200,
  "message": "OK",
  "errorMessage": null,
  "data": {
    "content": {
      "amount": 1000000
    },
    "pagination": null
  }
}
```

- Response Fields

| Path                | Type   | Description |
|---------------------|--------|-------------|
| code                | Number | 응답 코드       |
| message             | String | 응답 메세지      |
| errorMessage        | null   | 실패 이유       |
| data                | Object | 결과 데이터      |
| data.content        | Object | 잔액 조회 데이터   |
| data.content.amount | Number | 잔액          |
| data.pagination     | null   | 페이징 없음      |

<br>

#### [Error Spec]
| HTTP CODE | MESSAGE             | SOLUTION                  |
|-----------|---------------------|---------------------------|
| 400       | 유효하지 않은 사용자 ID 입니다. | 올바른 사용자 ID를 입력하였는지 확인합니다. |

<br>

---

### 잔액 충전

#### [Description]
사용자 잔액을 충전한다.   

#### [Request]
```http request
POST /api/v1/users/{userId}/points
Content-Type: application/json

{
  "amount": 10000
}
```
- Path Variable

| Parameter | Description |
|-----------|-------------|
| userId    | 사용자 ID    |

- Request Fields

| Path   | Type   | Required | Description |
|--------|--------|----------|-------------|
| amount | Number | true     | 충전 금액       |
<br>

#### [Response]

- Response Body

```json
// 200 OK
{
  "code": 200,
  "message": "OK",
  "errorMessage": null,
  "data": {
    "content": null,
    "pagination": null
  }
}
```

- Response Fields

| Path                | Type   | Description |
|---------------------|--------|-------------|
| code                | Number | 응답 코드       |
| message             | String | 응답 메세지      |
| errorMessage        | null   | 실패 이유       |
| data                | Object | 결과 데이터      |
| data.content        | null   | 결과 데이터 없음   |
| data.pagination     | null   | 페이징 없음      |

<br>

#### [Error Spec]
| HTTP CODE | MESSAGE                                                              | SOLUTION                  |
|-----------|----------------------------------------------------------------------|---------------------------|
| 400       | 유효하지 않은 사용자 ID 입니다.                                                  | 올바른 사용자 ID를 입력하였는지 확인합니다. |
| 400       | 잔액 충전 시 최소 금액은 10,000 이상 1,000,000 이하입니다.                            | 충전 금액을 올바르게 입력하였는지 확인합니다. |
| 400       | 잔액 최대 금액이 초과되었습니다. (현재 잔액: {currentAmount}, 충전 시도 잔액: {ChargeAmount} | 잔액을 사용한 뒤에 충전을 시도합니다.     |
