package com.ecommerce.port.out.coupon

import com.ecommerce.domain.model.Coupon

interface LoadCouponPort {
    fun loadById(couponId: Long): Coupon
}