package com.ecommerce.port.out.point

import com.ecommerce.domain.model.Point

interface SavePointPort {

    fun save(point: Point): Point
}