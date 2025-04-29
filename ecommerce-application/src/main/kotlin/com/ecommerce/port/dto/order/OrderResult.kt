package com.ecommerce.port.dto.order

import com.ecommerce.domain.model.Order
import java.time.LocalDateTime

data class OrderResult(
    val orderId: Long?,
    val totalAmount: Long,
    val totalDiscountAmount: Long,
    val status: String,
    val createdAt: LocalDateTime
) {
    companion object {
        fun from(order: Order): OrderResult =
            OrderResult(
                orderId = order.id,
                totalAmount = order.getTotalAmount(),
                totalDiscountAmount = order.getTotalDiscountAmount(),
                status = order.getStatus().name,
                createdAt = order.createdAt
            )
    }
}
