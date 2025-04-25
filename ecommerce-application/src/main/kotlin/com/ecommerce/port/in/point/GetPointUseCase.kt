package com.ecommerce.port.`in`.point

import com.ecommerce.port.dto.point.PointResult

interface GetPointUseCase {

    fun getPoint(userId: Long): PointResult
}