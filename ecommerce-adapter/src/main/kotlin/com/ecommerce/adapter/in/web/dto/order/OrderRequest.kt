package com.ecommerce.adapter.`in`.web.dto.order

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "주문 생성 모델")
data class OrderRequest(
    @field:Schema(description = "사용자 ID", type = "Long", example = "1L")
    val userId: Long,

    @field:Schema(description = "발급 쿠폰 ID", type = "Long", example = "1L")
    val issuedCouponId: Long,

    @field:Schema(description = "주문 상품 목록", type = "Array", example = "1L")
    val orderItems: List<OrderItemRequest>
) {

    data class OrderItemRequest(
        @field:Schema(description = "상품 ID", type = "Long", example = "1L")
        val itemId: Long,

        @field:Schema(description = "수량", type = "Int", example = "1")
        val quantity: Int
    )
}
