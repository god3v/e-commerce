package com.ecommerce.adapter.`in`.web.dto.payment

data class PaymentRequest(
    val userId: Long,
    val orderId: Long,
    val price: Int,
    val paymentMethod: String
)
