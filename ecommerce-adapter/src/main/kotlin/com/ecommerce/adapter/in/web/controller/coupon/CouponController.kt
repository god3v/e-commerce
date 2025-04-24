package com.ecommerce.adapter.`in`.web.controller.coupon

import com.ecommerce.adapter.`in`.web.dto.ApiResponse
import com.ecommerce.adapter.`in`.web.dto.coupon.CouponResponse
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
class CouponController: CouponApiController {

    @GetMapping("/users/{userId}/coupons")
    override fun getCoupons(@PathVariable userId: Long): ApiResponse<List<CouponResponse>> {

        return ApiResponse.success(
            listOf(CouponResponse(
                1L,
                "쿠폰",
                "정액",
                1000,
                1000,
                1000,
                false,
                LocalDateTime.now(),
                LocalDateTime.now(),
                LocalDateTime.now()
            ))
        )
    }

    @PostMapping("/users/{userId}/coupons")
    override fun issueCoupon(@RequestBody couponId: Long): ApiResponse<CouponResponse> {
        return ApiResponse.success(
            CouponResponse(
                1L,
                "쿠폰",
                "정액",
                1000,
                1000,
                1000,
                false,
                LocalDateTime.now(),
                LocalDateTime.now(),
                LocalDateTime.now()
            )
        )
    }
}