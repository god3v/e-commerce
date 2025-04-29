package com.ecommerce.domain.model

import java.time.LocalDateTime

class IssuedCoupon(
    val id: Long? = null,
    val coupon: Coupon,
    val userId: Long,
    private var used: Boolean = false
) {
    fun isUsed(): Boolean = used

    fun apply(orderAmount: Long): Long {
        validateUsable(orderAmount)
        this.used = true
        return coupon.calculateDiscount(orderAmount)
    }

    private fun validateUsable(orderAmount: Long) {
        require(!used) { "이미 사용된 쿠폰입니다." }
        coupon.validateUsable(LocalDateTime.now(), orderAmount)
    }
}