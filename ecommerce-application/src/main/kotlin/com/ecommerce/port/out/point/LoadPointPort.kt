package com.ecommerce.port.out.point

import com.ecommerce.domain.model.Point


interface LoadPointPort {

    fun loadByUserId(userId: Long): Point
}