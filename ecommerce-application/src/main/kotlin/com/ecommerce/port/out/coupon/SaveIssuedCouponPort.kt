package com.ecommerce.port.out.coupon

import com.ecommerce.domain.model.IssuedCoupon

interface SaveIssuedCouponPort {
    fun save(issuedCoupon: IssuedCoupon): IssuedCoupon
}