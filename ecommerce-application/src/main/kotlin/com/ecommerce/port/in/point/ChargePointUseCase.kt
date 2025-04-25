package com.ecommerce.port.`in`.point

import com.ecommerce.port.dto.point.PointResult

interface ChargePointUseCase {

    fun chargePoint(userId: Long, amount: Long): PointResult
}