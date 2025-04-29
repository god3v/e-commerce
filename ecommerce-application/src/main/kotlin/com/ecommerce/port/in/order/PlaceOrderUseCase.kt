package com.ecommerce.port.`in`.order

import com.ecommerce.port.dto.order.OrderResult
import com.ecommerce.port.dto.order.PlaceOrderCommand

interface PlaceOrderUseCase {
    fun placeOrder(command: PlaceOrderCommand): OrderResult
}