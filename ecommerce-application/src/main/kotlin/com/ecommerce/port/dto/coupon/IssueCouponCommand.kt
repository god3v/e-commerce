package com.ecommerce.port.dto.coupon

data class IssueCouponCommand(
    val userId: Long,
    val couponId: Long
)
