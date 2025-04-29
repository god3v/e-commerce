package com.ecommerce.port.out.coupon

import com.ecommerce.domain.model.CouponStock

interface SaveCouponStockPort {
    fun save(couponStock: CouponStock)
}