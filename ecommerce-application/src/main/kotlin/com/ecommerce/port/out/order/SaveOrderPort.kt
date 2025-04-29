package com.ecommerce.port.out.order

import com.ecommerce.domain.model.Order

interface SaveOrderPort {
    fun save(order: Order): Order
}