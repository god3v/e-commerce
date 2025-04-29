package com.ecommerce.domain.model

class Point(
    val userId: Long,
    private var amount: Long
) {
    fun charge(chargeAmount: Long) {
        require(chargeAmount > 0) { "충전 금액은 0보다 커야 합니다." }
        require(chargeAmount <= MAX_CHARGE_AMOUNT) { "1회 충전 금액은 최대 ${MAX_CHARGE_AMOUNT}원 입니다."}
        require(amount + chargeAmount <= MAX_TOTAL_AMOUNT) { "충전 후 잔액은 최대 ${MAX_CHARGE_AMOUNT}원을 초과할 수 없습니다."}

        amount += chargeAmount
    }

    fun currentAmount(): Long = amount

    companion object {
        const val MAX_CHARGE_AMOUNT = 1_000_000L
        const val MAX_TOTAL_AMOUNT = 1_000_000L
    }
}