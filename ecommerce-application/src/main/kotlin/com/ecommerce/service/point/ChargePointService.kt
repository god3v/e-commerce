package com.ecommerce.service.point

import com.ecommerce.port.dto.point.PointResult
import com.ecommerce.port.`in`.point.ChargePointUseCase
import com.ecommerce.port.out.point.ChargePointPort
import com.ecommerce.port.out.point.GetPointPort
import org.springframework.stereotype.Service

@Service
class ChargePointService(
    private val getPointPort: GetPointPort,
    private val chargePointPort: ChargePointPort
) : ChargePointUseCase {

    override fun chargePoint(userId: Long, amount: Long): PointResult {
        val point = getPointPort.findPoint(userId)
        point.charge(amount)
        val result = chargePointPort.save(point)
        return PointResult.from(result)
    }
}