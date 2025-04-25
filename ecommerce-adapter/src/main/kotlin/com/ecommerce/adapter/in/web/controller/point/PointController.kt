package com.ecommerce.adapter.`in`.web.controller.point

import com.ecommerce.adapter.`in`.web.dto.ApiResponse
import com.ecommerce.adapter.`in`.web.dto.point.PointResponse
import com.ecommerce.port.`in`.point.ChargePointUseCase
import com.ecommerce.port.`in`.point.GetPointUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class PointController(
    private val getPointUseCase: GetPointUseCase,
    private val chargePointUseCase: ChargePointUseCase
) : PointApiController {

    @GetMapping("/users/{userId}/points")
    override fun getPoint(@PathVariable userId: Long): ApiResponse<PointResponse> {
        val result = getPointUseCase.getPoint(userId)
        return ApiResponse.success(PointResponse.of(result))
    }

    @PostMapping("/users/{userId}/points")
    override fun chargePoint(@PathVariable userId: Long, @RequestBody amount: Long): ApiResponse<PointResponse> {
        val result = chargePointUseCase.chargePoint(userId, amount)
        return ApiResponse.success(PointResponse.of(result))
    }
}