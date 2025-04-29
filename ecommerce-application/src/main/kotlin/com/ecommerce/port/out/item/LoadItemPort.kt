package com.ecommerce.port.out.item

import com.ecommerce.domain.model.Item
import java.time.LocalDateTime

interface LoadItemPort {

    fun loadAll(): List<Item>
    fun loadById(itemId: Long): Item
    fun loadPopularItems(from: LocalDateTime): List<Item>
}