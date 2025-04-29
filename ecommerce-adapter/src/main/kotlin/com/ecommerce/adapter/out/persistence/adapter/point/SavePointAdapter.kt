package com.ecommerce.adapter.out.persistence.adapter.point

import com.ecommerce.domain.model.Point
import com.ecommerce.port.out.point.SavePointPort
import org.springframework.stereotype.Repository

@Repository
class SavePointAdapter(
) : SavePointPort {

    override fun save(point: Point): Point {
        return Point(point.userId, point.currentAmount())
    }
}