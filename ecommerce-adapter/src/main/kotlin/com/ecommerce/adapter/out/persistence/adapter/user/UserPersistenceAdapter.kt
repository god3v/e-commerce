package com.ecommerce.adapter.out.persistence.adapter.user

import com.ecommerce.domain.model.User
import com.ecommerce.port.out.user.LoadUserPort
import org.springframework.stereotype.Repository

@Repository
class UserPersistenceAdapter(
) : LoadUserPort {
    override fun loadById(userId: Long): User {
        return User(1L)
    }
}