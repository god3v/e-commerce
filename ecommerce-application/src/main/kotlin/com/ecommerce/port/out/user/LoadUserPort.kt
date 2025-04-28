package com.ecommerce.port.out.user

import com.ecommerce.domain.model.User

interface LoadUserPort {
    fun loadById(userId: Long): User
}