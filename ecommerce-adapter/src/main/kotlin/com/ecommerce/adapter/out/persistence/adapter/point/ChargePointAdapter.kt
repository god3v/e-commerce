package com.ecommerce.adapter.out.persistence.adapter.point

import com.ecommerce.adapter.out.persistence.repository.PointRepository
import com.ecommerce.domain.model.Point
import com.ecommerce.port.out.point.ChargePointPort
import org.springframework.stereotype.Repository

@Repository
class ChargePointAdapter(
//    private val pointRepository: PointRepository
) : ChargePointPort {

    override fun save(point: Point): Point {
//        return pointRepository.save(point)
        return Point(point.userId, point.currentAmount())
    }
}