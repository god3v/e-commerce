package com.ecommerce.adapter.out.persistence.adapter.point

import com.ecommerce.domain.model.Point
import com.ecommerce.port.out.point.LoadPointPort
import org.springframework.stereotype.Repository

@Repository
class LoadPointAdapter(
) : LoadPointPort {

    override fun loadByUserId(userId: Long): Point {
        return Point(userId, 0L)
    }
}