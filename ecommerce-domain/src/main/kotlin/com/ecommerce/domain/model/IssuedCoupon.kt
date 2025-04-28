package com.ecommerce.domain.model

import java.time.LocalDateTime

class IssuedCoupon(
    val id: Long? = null,
    val coupon: Coupon,
    val userId: Long,
    private var used: Boolean = false
) {
    fun isUsed(): Boolean = used

    fun isUsable(now: LocalDateTime, orderAmount: Long): Boolean {
        return !used &&
                now.isAfter(coupon.useStartAt) &&
                now.isBefore(coupon.useEndAt) &&
                orderAmount >= coupon.minOrderAmount
    }
}