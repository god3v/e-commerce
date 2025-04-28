package com.ecommerce.port.out.coupon

import com.ecommerce.domain.model.IssuedCoupon

interface LoadIssuedCouponPort {
    fun loadByUserId(userId: Long): List<IssuedCoupon>
}