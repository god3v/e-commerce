package com.ecommerce.port.dto.point

import com.ecommerce.domain.model.Point

data class PointResult(
    val userId: Long,
    val amount: Long
) {
    companion object {
        fun from(point: Point): PointResult =
            PointResult(
                userId = point.userId,
                amount = point.currentAmount()
            )
    }
}
