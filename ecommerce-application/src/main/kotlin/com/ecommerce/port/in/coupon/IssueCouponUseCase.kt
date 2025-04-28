package com.ecommerce.port.`in`.coupon

import com.ecommerce.port.dto.coupon.CouponResult
import com.ecommerce.port.dto.coupon.IssueCouponCommand

interface IssueCouponUseCase {
    fun issueCoupon(command: IssueCouponCommand): CouponResult
}