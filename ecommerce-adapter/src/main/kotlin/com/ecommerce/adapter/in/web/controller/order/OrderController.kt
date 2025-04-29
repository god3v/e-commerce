package com.ecommerce.adapter.`in`.web.controller.order

import com.ecommerce.adapter.`in`.web.dto.ApiResponse
import com.ecommerce.adapter.`in`.web.dto.order.OrderRequest
import com.ecommerce.adapter.`in`.web.dto.order.OrderResponse
import com.ecommerce.port.`in`.order.PlaceOrderUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/orders")
class OrderController(
    private val placeOrderUseCase: PlaceOrderUseCase
) : OrderApiController {

    @PostMapping
    override fun placeOrder(
        @RequestBody request: OrderRequest
    ): ApiResponse<OrderResponse> {
        val result = placeOrderUseCase.placeOrder(request.toCommand())
        return ApiResponse.success(OrderResponse.of(result))
    }
}