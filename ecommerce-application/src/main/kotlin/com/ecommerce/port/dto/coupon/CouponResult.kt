package com.ecommerce.port.dto.coupon

import com.ecommerce.domain.model.IssuedCoupon
import java.time.LocalDateTime

data class CouponResult(
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
        fun from(issuedCoupon: IssuedCoupon): CouponResult =
            CouponResult(
                id = issuedCoupon.id,
                name = issuedCoupon.coupon.name,
                discountType = issuedCoupon.coupon.discountType.name,
                discountValue = issuedCoupon.coupon.discountValue,
                minOrderAmount = issuedCoupon.coupon.minOrderAmount,
                maxDiscountAmount = issuedCoupon.coupon.maxDiscountAmount,
                useStartAt = issuedCoupon.coupon.useStartAt,
                useEndAt = issuedCoupon.coupon.useEndAt,
                used = issuedCoupon.isUsed()
            )
    }
}
