package com.ecommerce.adapter.`in`.web.dto.order

import com.ecommerce.port.dto.order.OrderResult

data class OrderResponse(
    val orderId: Long?
) {
    companion object {
        fun of(result: OrderResult): OrderResponse =
            OrderResponse(
                orderId = result.orderId
            )
    }
}
