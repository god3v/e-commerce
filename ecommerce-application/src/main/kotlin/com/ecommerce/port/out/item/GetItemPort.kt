package com.ecommerce.port.out.item

import com.ecommerce.domain.model.Item
import java.time.LocalDateTime

interface GetItemPort {

    fun findItems(): List<Item>
    fun findTopSellingItems(from: LocalDateTime): List<Item>
}