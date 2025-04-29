package com.ecommerce.adapter.`in`.web.controller.payment

import com.ecommerce.adapter.`in`.web.dto.ApiResponse
import com.ecommerce.adapter.`in`.web.dto.payment.PaymentRequest
import com.ecommerce.adapter.`in`.web.dto.payment.PaymentResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/payments")
class PaymentController: PaymentApiController {

    @PostMapping
    override fun payment(
        @RequestBody request: PaymentRequest
    ): ApiResponse<PaymentResponse> {
        return ApiResponse.success(
            PaymentResponse(1L, "결제 완료")
        )
    }
}