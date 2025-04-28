package com.ecommerce.port.out.coupon

import com.ecommerce.domain.model.CouponStock

interface CouponStockCommandPort {
    fun save(couponStock: CouponStock)
}