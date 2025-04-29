package com.ecommerce.domain.model
class OrderLineItem(
    val id: Long?,
    val quantity: Long,
    val price: Long,
    val item: Item
) {
    companion object {
        fun register(quantity: Long, item: Item): OrderLineItem =
            OrderLineItem(
                id = null,
                quantity = quantity,
                price = item.price,
                item = item
            )
    }

    fun calculateAmount(): Long = price * quantity

    fun decreaseStock() {
        item.decreaseStock(quantity)
    }
}
