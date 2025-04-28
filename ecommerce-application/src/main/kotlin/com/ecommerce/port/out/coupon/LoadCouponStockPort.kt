package com.ecommerce.port.out.coupon

import com.ecommerce.domain.model.CouponStock

interface LoadCouponStockPort {
    fun loadByCouponId(couponId: Long): CouponStock
}