package com.ecommerce.adapter.out.persistence.adapter.coupon

import com.ecommerce.domain.model.CouponStock
import com.ecommerce.port.out.coupon.SaveCouponStockPort
import com.ecommerce.port.out.coupon.LoadCouponStockPort
import org.springframework.stereotype.Repository

@Repository
class SaveCouponStockPersistenceAdapter(

) : LoadCouponStockPort,
    SaveCouponStockPort {

    override fun loadByCouponId(couponId: Long): CouponStock {
        return CouponStock(1L, 100L)
    }

    override fun save(couponStock: CouponStock) {
        println("저장 $couponStock")
    }
}