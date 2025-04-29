package com.ecommerce.service.coupon

import com.ecommerce.port.dto.coupon.CouponResult
import com.ecommerce.port.`in`.coupon.GetCouponUseCase
import com.ecommerce.port.out.coupon.LoadIssuedCouponPort
import org.springframework.stereotype.Service

@Service
class GetCouponService(
    private val loadIssuedCouponPort: LoadIssuedCouponPort
) : GetCouponUseCase {

    override fun getIssuedCoupons(userId: Long): List<CouponResult> {
        val issuedCoupons = loadIssuedCouponPort.loadByUserId(userId)

        return issuedCoupons.map { CouponResult.from(it) }
    }
}