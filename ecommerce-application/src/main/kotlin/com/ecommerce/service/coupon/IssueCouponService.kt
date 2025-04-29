package com.ecommerce.service.coupon

import com.ecommerce.port.dto.coupon.CouponResult
import com.ecommerce.port.dto.coupon.IssueCouponCommand
import com.ecommerce.port.`in`.coupon.IssueCouponUseCase
import com.ecommerce.port.out.coupon.SaveCouponStockPort
import com.ecommerce.port.out.coupon.SaveIssuedCouponPort
import com.ecommerce.port.out.coupon.LoadCouponPort
import com.ecommerce.port.out.coupon.LoadCouponStockPort
import com.ecommerce.port.out.user.LoadUserPort
import org.springframework.stereotype.Service

@Service
class IssueCouponService(
    private val loadUserPort: LoadUserPort,
    private val loadCouponPort: LoadCouponPort,
    private val loadCouponStockPort: LoadCouponStockPort,
    private val saveCouponStockPort: SaveCouponStockPort,
    private val issuedCouponCommandPort: SaveIssuedCouponPort
) : IssueCouponUseCase {

    override fun issueCoupon(command: IssueCouponCommand): CouponResult {
        // 사용자 조회 및 검증
        loadUserPort.loadById(command.userId)
        // 쿠폰 및 재고 조회
        val coupon = loadCouponPort.loadById(command.couponId)
        val stock = loadCouponStockPort.loadByCouponId(command.couponId)
        // 쿠폰 발급
        val issuedCoupon = coupon.issueTo(command.userId, stock = stock)
        // 재고 감소
        saveCouponStockPort.save(stock)
        // 발급 쿠폰 저장
        val saved = issuedCouponCommandPort.save(issuedCoupon)
        return CouponResult.from(saved)
    }
}