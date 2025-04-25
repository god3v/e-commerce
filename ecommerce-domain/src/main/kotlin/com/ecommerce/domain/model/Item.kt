package com.ecommerce.domain.model

class Item(
    val id: Long,
    val name: String,
    val price: Long,
    val stock: Long,
    var status: Status
) {
    enum class Status(val description: String) {
        ON_SALE("판매중"),
        STOPPED("판매중단")
    }
}