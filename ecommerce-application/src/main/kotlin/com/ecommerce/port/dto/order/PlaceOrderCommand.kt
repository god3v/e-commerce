package com.ecommerce.port.dto.order

data class PlaceOrderCommand(
    val userId: Long,
    val issuedCouponId: Long?,
    val items: List<OrderItem>
) {
    data class OrderItem(
        val itemId: Long,
        val quantity: Long
    )
}