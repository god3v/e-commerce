package com.ecommerce.service.item

import com.ecommerce.port.dto.common.PeriodType
import com.ecommerce.port.dto.item.ItemResult
import com.ecommerce.port.`in`.item.GetItemUseCase
import com.ecommerce.port.out.item.GetItemPort
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GetItemService(
    private val getItemPort: GetItemPort
) : GetItemUseCase {

    override fun getItems(): List<ItemResult> {
        val items = getItemPort.findItems()
        return items.map { ItemResult.from(it) }
    }

    override fun getPopularItems(period: PeriodType): List<ItemResult> {
        val from = LocalDateTime.now().minusDays(period.days)
        val items = getItemPort.findTopSellingItems(from)
        return items.map { ItemResult.from(it) }
    }
}