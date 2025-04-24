package com.ecommerce.adapter.`in`.web.controller.point

import com.ecommerce.adapter.`in`.web.dto.ApiResponse
import com.ecommerce.adapter.`in`.web.dto.point.PointResponse
import com.ecommerce.port.`in`.point.GetPointUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class PointController: PointApiController {
class PointController(
) : PointApiController {

    @GetMapping("/users/{userId}/points")
    override fun getPoint(@PathVariable userId: Long): ResponseEntity<ApiResponse<PointResponse>> {
        return ResponseEntity.ok(
            ApiResponse.success(PointResponse(1L, 10_000L))
        )
    override fun getPoint(@PathVariable userId: Long): ApiResponse<PointResponse> {
        return ApiResponse.success(PointResponse(point.userId, point.amount))
    }

    @PostMapping("/users/{userId}/points")
    override fun chargePoint(@PathVariable userId: Long): ApiResponse<PointResponse> {
        return ApiResponse.success(PointResponse(1L, 10_000L))
    }
}