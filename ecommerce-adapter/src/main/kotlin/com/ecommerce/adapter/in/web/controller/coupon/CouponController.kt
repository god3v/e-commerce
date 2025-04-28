package com.ecommerce.adapter.`in`.web.controller.coupon

import com.ecommerce.adapter.`in`.web.dto.ApiResponse
import com.ecommerce.adapter.`in`.web.dto.coupon.CouponResponse
import com.ecommerce.port.dto.coupon.IssueCouponCommand
import com.ecommerce.port.`in`.coupon.GetCouponUseCase
import com.ecommerce.port.`in`.coupon.IssueCouponUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.Date

@RestController
@RequestMapping("/api/v1")
class CouponController(
    private val getCouponUseCase: GetCouponUseCase,
    private val issueCouponUseCase: IssueCouponUseCase
) : CouponApiController {

    @GetMapping("/users/{userId}/coupons")
    override fun getIssuedCoupons(
        @PathVariable userId: Long
    ): ApiResponse<List<CouponResponse>> {
        val result = getCouponUseCase.getIssuedCoupons(userId)
        return ApiResponse.success(result.map { CouponResponse.of(it) })
    }

    @PostMapping("/coupons/{couponId}")
    override fun issueCoupon(
        @PathVariable couponId: Long,
        @RequestBody userId: Long
    ): ApiResponse<CouponResponse> {
        val result = issueCouponUseCase.issueCoupon(IssueCouponCommand(couponId, userId))
        return ApiResponse.success(CouponResponse.of(result))
    }
}