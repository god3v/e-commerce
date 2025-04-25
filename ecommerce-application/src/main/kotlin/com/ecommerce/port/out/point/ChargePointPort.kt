package com.ecommerce.port.out.point

import com.ecommerce.domain.model.Point

interface ChargePointPort {

    fun save(point: Point): Point
}