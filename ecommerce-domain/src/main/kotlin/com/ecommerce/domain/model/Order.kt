package com.ecommerce.domain.model

import java.time.LocalDateTime

class Order(
    val id: Long?,
    val userId: Long,
    val items: List<OrderLineItem>,
    val issuedCoupon: IssuedCoupon?,
    private var totalAmount: Long = 0,
    private var totalDiscountAmount: Long = 0,
    private var status: OrderStatus = OrderStatus.PENDING,
    val createdAt: LocalDateTime
) {
    enum class OrderStatus { PENDING, ORDERED, PAID, CANCELED }

    fun getTotalAmount(): Long = totalAmount
    fun getTotalDiscountAmount(): Long = totalDiscountAmount
    fun getStatus(): OrderStatus = status

    companion object {
        fun of(userId: Long, items: List<OrderLineItem>, issuedCoupon: IssuedCoupon?): Order =
            Order(
                id = null,
                userId = userId,
                items = items,
                issuedCoupon = issuedCoupon,
                createdAt = LocalDateTime.now()
            )
    }

    fun place() {
        calculateTotalAmount()
        issuedCoupon?.let { applyCoupon(it) }
        decreaseItemStock()
        ordered()
    }

    private fun calculateTotalAmount() {
        this.totalAmount = items.sumOf { it.calculateAmount() }
    }

    private fun applyCoupon(issuedCoupon: IssuedCoupon) {
        this.totalDiscountAmount = issuedCoupon.apply(totalAmount)
    }

    private fun decreaseItemStock() {
        items.forEach { it.decreaseStock() }
    }

    private fun ordered() {
        this.status = OrderStatus.ORDERED
    }
}