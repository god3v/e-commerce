package com.ecommerce.adapter.out.persistence.adapter.coupon

import com.ecommerce.domain.model.Coupon
import com.ecommerce.domain.model.IssuedCoupon
import com.ecommerce.port.out.coupon.LoadCouponPort
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class CouponPersistenceAdapter(

) : LoadCouponPort {
    override fun loadById(couponId: Long): Coupon {
        return Coupon(1L, "1번 쿠폰", Coupon.DiscountType.RATE,
            10, 10_000, 1_000, 10,
            LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now())
    }
}