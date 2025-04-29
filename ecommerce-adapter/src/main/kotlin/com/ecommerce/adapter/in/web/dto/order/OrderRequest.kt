package com.ecommerce.adapter.`in`.web.dto.order

import com.ecommerce.port.dto.order.PlaceOrderCommand

data class OrderRequest(
    val userId: Long,
    val issuedCouponId: Long?,
    val items: List<OrderItemRequest>
) {
    data class OrderItemRequest(
        val itemId: Long,
        val quantity: Long
    )

    fun toCommand(): PlaceOrderCommand {
        return PlaceOrderCommand(
            userId = userId,
            issuedCouponId = issuedCouponId,
            items = items.map { PlaceOrderCommand.OrderItem(itemId = it.itemId, quantity = it.quantity) }
        )
    }
}
