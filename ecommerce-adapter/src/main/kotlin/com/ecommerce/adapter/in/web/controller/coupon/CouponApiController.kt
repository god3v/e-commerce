package com.ecommerce.adapter.`in`.web.controller.coupon

import com.ecommerce.adapter.`in`.web.dto.coupon.CouponResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "Coupon", description = "쿠폰 관련 API")
@RequestMapping("/api/v1")
interface CouponApiController {

    @Operation(summary = "보유 쿠폰 목록 조회", description = "사용자의 보유 쿠폰 목록을 조회합니다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "성공"),
            ApiResponse(responseCode = "404", description = "유효하지 않은 사용자 ID")
        ]
    )
    @GetMapping("/users/{userId}/coupons")
    fun getIssuedCoupons(
        @Parameter(description = "조회할 사용자 ID", example = "1L")
        @PathVariable userId: Long
    ): com.ecommerce.adapter.`in`.web.dto.ApiResponse<List<CouponResponse>>

    @Operation(summary = "쿠폰 발급", description = "쿠폰을 발급 받습니다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "성공"),
            ApiResponse(responseCode = "400", description = "쿠폰 소진"),
            ApiResponse(responseCode = "404", description = "유효하지 않은 사용자 ID")
        ]
    )
    @PostMapping("/coupons/{couponId}")
    fun issueCoupon(
        @PathVariable couponId: Long,
        @RequestBody userId: Long,
    ): com.ecommerce.adapter.`in`.web.dto.ApiResponse<CouponResponse>
}