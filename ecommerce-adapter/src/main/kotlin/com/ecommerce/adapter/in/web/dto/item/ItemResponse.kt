package com.ecommerce.adapter.`in`.web.dto.item

import com.ecommerce.port.dto.item.ItemResult

data class ItemResponse(
    val id: Long,
    val name: String,
    val price: Long,
    val stock: Long,
    val status: String
) {
    companion object {
        fun of(itemResult: ItemResult): ItemResponse =
            ItemResponse(
                id = itemResult.id,
                name = itemResult.name,
                price = itemResult.price,
                stock = itemResult.stock,
                status = itemResult.status
            )
    }
}
