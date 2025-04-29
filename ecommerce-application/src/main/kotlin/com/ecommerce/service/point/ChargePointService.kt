package com.ecommerce.service.point

import com.ecommerce.port.dto.point.PointResult
import com.ecommerce.port.`in`.point.ChargePointUseCase
import com.ecommerce.port.out.point.LoadPointPort
import com.ecommerce.port.out.point.SavePointPort
import org.springframework.stereotype.Service

@Service
class ChargePointService(
    private val loadPointPort: LoadPointPort,
    private val savePointPort: SavePointPort
) : ChargePointUseCase {

    override fun chargePoint(userId: Long, amount: Long): PointResult {
        val point = loadPointPort.loadByUserId(userId)
        point.charge(amount)
        val result = savePointPort.save(point)
        return PointResult.from(result)
    }
}