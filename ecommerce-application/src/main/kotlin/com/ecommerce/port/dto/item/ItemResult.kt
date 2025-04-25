package com.ecommerce.port.dto.item

import com.ecommerce.domain.model.Item

data class ItemResult(
    val id: Long,
    val name: String,
    val price: Long,
    val stock: Long,
    val status: String,
) {
    companion object {
        fun from(item: Item): ItemResult =
            ItemResult(
                id = item.id,
                name = item.name,
                price = item.price,
                stock = item.stock,
                status = item.status.description
            )
    }
}
