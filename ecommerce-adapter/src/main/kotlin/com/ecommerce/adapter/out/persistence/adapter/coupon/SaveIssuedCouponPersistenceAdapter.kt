package com.ecommerce.adapter.out.persistence.adapter.coupon

import com.ecommerce.domain.model.Coupon
import com.ecommerce.domain.model.IssuedCoupon
import com.ecommerce.port.out.coupon.SaveIssuedCouponPort
import com.ecommerce.port.out.coupon.LoadIssuedCouponPort
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class SaveIssuedCouponPersistenceAdapter(

) : LoadIssuedCouponPort,
    SaveIssuedCouponPort {

    override fun loadByUserId(userId: Long): List<IssuedCoupon> {
        return listOf(
            IssuedCoupon(
                1L,
                Coupon(
                    1L,
                    "1번 쿠폰",
                    Coupon.DiscountType.RATE,
                    10L,
                    10_000L,
                    2_000L,
                    100,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    LocalDateTime.now()),
                1L,
                true),
            IssuedCoupon(
                2L,
                Coupon(
                    2L,
                    "1번 쿠폰",
                    Coupon.DiscountType.FIXED,
                    2_000L,
                    10_000L,
                    2_000L,
                    100,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    LocalDateTime.now()),
                1L,
                false
            )
        )
    }

    override fun loadById(issuedCouponId: Long): IssuedCoupon {
        return IssuedCoupon(
            1L,
            Coupon(
                1L,
                "1번 쿠폰",
                Coupon.DiscountType.RATE,
                10L,
                10_000L,
                2_000L,
                100,
                LocalDateTime.now(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                LocalDateTime.now()),
            1L,
            false)
    }

    override fun save(issuedCoupon: IssuedCoupon): IssuedCoupon {
        return IssuedCoupon(
            issuedCoupon.id,
            issuedCoupon.coupon,
            issuedCoupon.userId
        )
    }
}