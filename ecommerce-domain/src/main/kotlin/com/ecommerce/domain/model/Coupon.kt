package com.ecommerce.domain.model

import java.time.LocalDateTime

class Coupon(
    val id: Long,
    val name: String,
    val discountType: DiscountType,
    val discountValue: Long,
    val minOrderAmount: Long,
    val maxDiscountAmount: Long,
    private var stock: Long,
    val issueStartAt: LocalDateTime,        // 쿠폰 발급 시작 시간
    val issueEndAt: LocalDateTime,          // 쿠폰 발급 종료 시간
    val useStartAt: LocalDateTime,          // 쿠폰 사용 가능 시작 시간
    val useEndAt: LocalDateTime     // 쿠폰 사용 가능 종료 시간
) {
    enum class DiscountType { FIXED, RATE }

    fun issueTo(userId: Long, stock: CouponStock): IssuedCoupon {
        stock.decrease()
        return IssuedCoupon(
            coupon = this,
            userId = userId
        )
    }

    fun calculateDiscount(orderAmount: Long): Long {
        val rawDiscount = when (discountType) {
            DiscountType.FIXED -> discountValue
            DiscountType.RATE -> orderAmount * discountValue / 100
        }
        return rawDiscount.coerceAtMost(maxDiscountAmount)
    }

    fun validateUsable(now: LocalDateTime, orderAmount: Long) {
        require(now.isAfter(useStartAt) && now.isBefore(useEndAt)) { "쿠폰 사용 가능 기간이 아닙니다." }
        require(orderAmount >= minOrderAmount) { "최소 주문 금액을 만족하지 않습니다." }
    }
}