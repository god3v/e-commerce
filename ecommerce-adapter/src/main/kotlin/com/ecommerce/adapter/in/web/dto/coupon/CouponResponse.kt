package com.ecommerce.adapter.`in`.web.dto.coupon

import java.time.LocalDateTime

data class CouponResponse(
    val id: Long,
    val name: String,
    val discountType: String,
    val discountAmount: Int,
    val minPayAmount: Int,
    val maxDiscountAmount: Int,
    val isUsed: Boolean,
    val useStartAt: LocalDateTime,
    val useEndAt: LocalDateTime,
    val issuedAt: LocalDateTime
)
