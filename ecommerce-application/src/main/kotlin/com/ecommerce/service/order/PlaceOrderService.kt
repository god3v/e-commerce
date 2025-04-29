package com.ecommerce.service.order

import com.ecommerce.domain.model.Order
import com.ecommerce.domain.model.OrderLineItem
import com.ecommerce.port.dto.order.OrderResult
import com.ecommerce.port.dto.order.PlaceOrderCommand
import com.ecommerce.port.`in`.order.PlaceOrderUseCase
import com.ecommerce.port.out.coupon.LoadIssuedCouponPort
import com.ecommerce.port.out.coupon.SaveIssuedCouponPort
import com.ecommerce.port.out.item.LoadItemPort
import com.ecommerce.port.out.item.SaveItemPort
import com.ecommerce.port.out.order.SaveOrderPort
import com.ecommerce.port.out.user.LoadUserPort
import org.springframework.stereotype.Service

@Service
class PlaceOrderService(
    private val loadUserPort: LoadUserPort,
    private val loadItemPort: LoadItemPort,
    private val saveItemPort: SaveItemPort,
    private val loadIssuedCouponPort: LoadIssuedCouponPort,
    private val saveIssuedCouponPort: SaveIssuedCouponPort,
    private val saveOrderPort: SaveOrderPort
) : PlaceOrderUseCase {
    override fun placeOrder(command: PlaceOrderCommand): OrderResult {
        // 사용자 정보 조회
        loadUserPort.loadById(command.userId)
        // 주문 상품 ID로 상품 조회
        val items = command.items.map { loadItemPort.loadById(it.itemId) }
        // 주문 상품 등록
        val lineItems = command.items.mapIndexed { idx, it ->
            OrderLineItem.register(it.quantity, items[idx])
        }
        // 쿠폰 조회
        val issuedCoupon = command.issuedCouponId?.let { loadIssuedCouponPort.loadById(command.issuedCouponId) }
        // 주문 생성
        val order = Order.of(command.userId, lineItems, issuedCoupon)
        order.place()
        // 주문 정상 생성 시 재고 차감
        items.forEach { saveItemPort.save(it) }
        // 쿠폰 사용 처리
        issuedCoupon?.let { saveIssuedCouponPort.save(issuedCoupon) }
        // 주문 저장
        return OrderResult.from(saveOrderPort.save(order))
    }
}