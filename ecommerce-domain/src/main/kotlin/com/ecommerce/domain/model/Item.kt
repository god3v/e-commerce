package com.ecommerce.domain.model

class Item(
    val id: Long,
    val name: String,
    val price: Long,
    private var stock: Long,
    private var status: ItemStatus
) {
    fun getStock(): Long = stock
    fun getStatus(): ItemStatus = status

    enum class ItemStatus(val description: String) {
        ON_SALE("판매중"),
        STOPPED("판매중단")
    }

    fun decreaseStock(quantity: Long) {
        require(stock >= quantity) { "재고가 부족합니다." }
        stock -= quantity
    }
}