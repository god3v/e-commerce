package com.ecommerce.adapter.out.persistence.repository

import com.ecommerce.domain.model.Point


interface PointRepository {

    fun findByUserId(userId: Long): Point
    fun save(point: Point): Point
}