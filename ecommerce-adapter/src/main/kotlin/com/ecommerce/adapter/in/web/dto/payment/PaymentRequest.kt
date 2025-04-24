package com.ecommerce.adapter.`in`.web.dto.payment

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "결제 요청 모델")
data class PaymentRequest(
    @field:Schema(description = "사용자 ID", type = "Long", example = "1L")
    val userId: Long,
    @field:Schema(description = "주문 ID", type = "Long", example = "1L")
    val orderId: Long,
    @field:Schema(description = "주문 가격", type = "Int", example = "1L")
    val price: Int,
    @field:Schema(description = "결제 수단", type = "String", example = "CASH")
    val paymentMethod: String
)
