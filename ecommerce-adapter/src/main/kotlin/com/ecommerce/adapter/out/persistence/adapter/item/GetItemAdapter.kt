package com.ecommerce.adapter.out.persistence.adapter.item

import com.ecommerce.domain.model.Item
import com.ecommerce.port.out.item.GetItemPort
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class GetItemAdapter(
) : GetItemPort {

    override fun findItems(): List<Item> {
        return listOf(
            Item(1L, "1번 아이템", 10_000L, 100L, Item.Status.ON_SALE),
            Item(2L, "2번 아이템", 1_000L, 50L, Item.Status.STOPPED)
        )
    }

    override fun findTopSellingItems(from: LocalDateTime): List<Item> {
        return listOf(
            Item(1L, "1번 아이템", 10_000L, 100L, Item.Status.ON_SALE),
            Item(2L, "2번 아이템", 1_000L, 50L, Item.Status.STOPPED)
        )
    }
}