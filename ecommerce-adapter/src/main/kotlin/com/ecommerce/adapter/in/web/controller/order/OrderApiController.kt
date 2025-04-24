package com.ecommerce.adapter.`in`.web.controller.order

import com.ecommerce.adapter.`in`.web.dto.order.OrderRequest
import com.ecommerce.adapter.`in`.web.dto.order.OrderResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "Order", description = "주문 관련 API")
@RequestMapping("/api/v1/orders")
interface OrderApiController {

    @Operation(summary = "주문 생성", description = "주문을 생성합니다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "성공"),
            ApiResponse(responseCode = "400", description = "유효하지 않은 사용자 ID"),
            ApiResponse(responseCode = "400", description = "유효하지 않은 발급 쿠폰 ID"),
            ApiResponse(responseCode = "400", description = "유효하지 않은 상품 ID"),
            ApiResponse(responseCode = "400", description = "주문 상품 누락"),
            ApiResponse(responseCode = "400", description = "주문 상품 수량 누략"),
            ApiResponse(responseCode = "400", description = "쿠폰 유효기간 만료"),
            ApiResponse(responseCode = "400", description = "판매 중지 상품"),
            ApiResponse(responseCode = "400", description = "품절 상품"),
        ]
    )
    @PostMapping
    fun placeOrder(
        @RequestBody request: OrderRequest
    ): com.ecommerce.adapter.`in`.web.dto.ApiResponse<OrderResponse>
}