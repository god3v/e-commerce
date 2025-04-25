package com.ecommerce.port.out.point

import com.ecommerce.domain.model.Point


interface GetPointPort {

    fun findPoint(userId: Long): Point
}