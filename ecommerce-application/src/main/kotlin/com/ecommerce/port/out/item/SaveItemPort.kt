package com.ecommerce.port.out.item

import com.ecommerce.domain.model.Item
import org.springframework.stereotype.Repository

@Repository
interface SaveItemPort {
    fun save(item: Item): Item
}