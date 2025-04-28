package com.ecommerce.domain.model

class CouponStock(
    val couponId: Long,
    private var quantity: Long
) {
    fun decrease() {
        require(quantity > 0) { "남은 수량이 없습니다." }
        quantity -= 1
    }
}