package com.ecommerce.port.out.coupon

import com.ecommerce.domain.model.IssuedCoupon

interface IssuedCouponCommandPort {
    fun save(issuedCoupon: IssuedCoupon): IssuedCoupon
}