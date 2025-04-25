package com.ecommerce.service.point

import com.ecommerce.port.dto.point.PointResult
import com.ecommerce.port.`in`.point.GetPointUseCase
import com.ecommerce.port.out.point.GetPointPort
import org.springframework.stereotype.Service

@Service
class GetPointService(
    private val getPointPort: GetPointPort
) : GetPointUseCase {

    override fun getPoint(userId: Long): PointResult {
        val point = getPointPort.findPoint(userId)

        return PointResult.from(point)
    }

}