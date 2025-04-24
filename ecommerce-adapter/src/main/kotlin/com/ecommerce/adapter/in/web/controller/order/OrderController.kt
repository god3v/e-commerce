package com.ecommerce.adapter.`in`.web.controller.order

import com.ecommerce.adapter.`in`.web.dto.ApiResponse
import com.ecommerce.adapter.`in`.web.dto.order.OrderRequest
import com.ecommerce.adapter.`in`.web.dto.order.OrderResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/orders")
class OrderController: OrderApiController {

    @PostMapping
    override fun placeOrder(@RequestBody request: OrderRequest): ApiResponse<OrderResponse> {
        return ApiResponse.success(
            OrderResponse(1L)
        )
    }
}