package com.ecommerce.adapter.`in`.web.controller.payment

import com.ecommerce.adapter.`in`.web.dto.payment.PaymentRequest
import com.ecommerce.adapter.`in`.web.dto.payment.PaymentResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "Payment", description = "결제 관련 API")
@RequestMapping("/api/v1/payments")
interface PaymentApiController {

    @Operation(summary = "결제 요청", description = "결제를 요청합니다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "성공"),
            ApiResponse(responseCode = "400", description = "유효하지 않은 사용자 ID"),
            ApiResponse(responseCode = "400", description = "유효하지 않은 주문 ID"),
            ApiResponse(responseCode = "400", description = "결제 잔액 부족"),
            ApiResponse(responseCode = "400", description = "유효하지 않은 결제 수단"),
            ApiResponse(responseCode = "500", description = "PG사 에러"),
        ]
    )
    @PostMapping
    fun payment(
        @RequestBody request: PaymentRequest
    ): ResponseEntity<com.ecommerce.adapter.`in`.web.dto.ApiResponse<PaymentResponse>>
}