package com.ecommerce.adapter.out.persistence.adapter

import com.ecommerce.adapter.out.persistence.repository.PointRepository
import com.ecommerce.domain.model.Point
import com.ecommerce.port.out.point.GetPointPort
import org.springframework.stereotype.Repository

@Repository
class GetPointAdapter(
    private val pointRepository: PointRepository
) : GetPointPort {

    override fun findPoint(userId: Long): Point {
        return pointRepository.findByUserId(userId);
    }
}