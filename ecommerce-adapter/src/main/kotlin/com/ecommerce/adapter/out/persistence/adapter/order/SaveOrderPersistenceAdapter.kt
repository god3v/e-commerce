package com.ecommerce.adapter.out.persistence.adapter.order

import com.ecommerce.domain.model.Order
import com.ecommerce.port.out.order.SaveOrderPort
import org.springframework.stereotype.Repository

@Repository
class SaveOrderPersistenceAdapter(

) : SaveOrderPort {
    override fun save(order: Order): Order {
        return order
    }
}