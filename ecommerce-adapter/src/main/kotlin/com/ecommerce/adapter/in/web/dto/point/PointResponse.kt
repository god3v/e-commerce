package com.ecommerce.adapter.`in`.web.dto.point

import com.ecommerce.port.dto.point.PointResult

data class PointResponse(
    val userId: Long,
    val amount: Long
) {
    companion object {
        fun of(pointResult: PointResult): PointResponse =
            PointResponse(
                userId = pointResult.userId,
                amount = pointResult.amount
            )
    }
}
