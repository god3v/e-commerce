package com.ecommerce.port.`in`.item

import com.ecommerce.port.dto.common.PeriodType
import com.ecommerce.port.dto.item.ItemResult

interface GetItemUseCase {

    fun getItems(): List<ItemResult>
    fun getPopularItems(period: PeriodType): List<ItemResult>
}