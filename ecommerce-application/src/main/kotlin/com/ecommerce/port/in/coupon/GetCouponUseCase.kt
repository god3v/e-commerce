package com.ecommerce.port.`in`.coupon

import com.ecommerce.port.dto.coupon.CouponResult

interface GetCouponUseCase {

    fun getIssuedCoupons(userId: Long): List<CouponResult>
}