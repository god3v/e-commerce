package com.ecommerce.service.item

import com.ecommerce.port.dto.common.PeriodType
import com.ecommerce.port.dto.item.ItemResult
import com.ecommerce.port.`in`.item.GetItemUseCase
import com.ecommerce.port.out.item.LoadItemPort
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GetItemService(
    private val loadItemPort: LoadItemPort
) : GetItemUseCase {

    override fun getItems(): List<ItemResult> {
        val items = loadItemPort.loadAll()
        return items.map { ItemResult.from(it) }
    }

    override fun getPopularItems(period: PeriodType): List<ItemResult> {
        val from = LocalDateTime.now().minusDays(period.days)
        val items = loadItemPort.loadPopularItems(from)
        return items.map { ItemResult.from(it) }
    }
}