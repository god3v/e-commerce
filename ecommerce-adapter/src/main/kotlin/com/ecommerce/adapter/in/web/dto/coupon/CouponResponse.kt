package com.ecommerce.adapter.`in`.web.dto.coupon

import com.ecommerce.port.dto.coupon.CouponResult
import java.time.LocalDateTime

data class CouponResponse(
    val id: Long?,
    val name: String,
    val discountType: String,
    val discountValue: Long,
    val minOrderAmount: Long,
    val maxDiscountAmount: Long,
    val useStartAt: LocalDateTime,
    val useEndAt: LocalDateTime,
    val used: Boolean
) {
    companion object {
        fun of(result: CouponResult): CouponResponse =
            CouponResponse(
                id = result.id,
                name = result.name,
                discountType = result.discountType,
                discountValue = result.discountValue,
                minOrderAmount = result.minOrderAmount,
                maxDiscountAmount = result.maxDiscountAmount,
                useStartAt = result.useStartAt,
                useEndAt = result.useEndAt,
                used = result.used
            )
    }
}
