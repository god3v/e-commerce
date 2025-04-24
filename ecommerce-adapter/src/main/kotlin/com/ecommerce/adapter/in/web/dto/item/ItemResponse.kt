package com.ecommerce.adapter.`in`.web.dto.item

data class ItemResponse(
    val id: Long,
    val name: String,
    val price: Int,
    val status: String,
    val stock: Int,
    val salesCount: Int? = null
)
