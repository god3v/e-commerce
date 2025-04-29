package com.ecommerce.adapter.out.persistence.adapter.item

import com.ecommerce.domain.model.Item
import com.ecommerce.port.out.item.LoadItemPort
import com.ecommerce.port.out.item.SaveItemPort
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class ItemPersistenceAdapter(
) : LoadItemPort,
    SaveItemPort {

    override fun loadAll(): List<Item> {
        return listOf(
            Item(1L, "1번 아이템", 10_000L, 100L, Item.ItemStatus.ON_SALE),
            Item(2L, "2번 아이템", 1_000L, 50L, Item.ItemStatus.STOPPED)
        )
    }

    override fun loadById(itemId: Long): Item {
        return Item(1L, "1번 아이템", 10_000L, 100L, Item.ItemStatus.ON_SALE)
    }

    override fun loadPopularItems(from: LocalDateTime): List<Item> {
        return listOf(
            Item(1L, "1번 아이템", 10_000L, 100L, Item.ItemStatus.ON_SALE),
            Item(2L, "2번 아이템", 1_000L, 50L, Item.ItemStatus.STOPPED)
        )
    }

    override fun save(item: Item): Item {
        return item
    }
}