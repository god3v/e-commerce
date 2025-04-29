package com.ecommerce.service.point

import com.ecommerce.port.dto.point.PointResult
import com.ecommerce.port.`in`.point.GetPointUseCase
import com.ecommerce.port.out.point.LoadPointPort
import org.springframework.stereotype.Service

@Service
class GetPointService(
    private val loadPointPort: LoadPointPort
) : GetPointUseCase {

    override fun getPoint(userId: Long): PointResult {
        val point = loadPointPort.loadByUserId(userId)

        return PointResult.from(point)
    }

}