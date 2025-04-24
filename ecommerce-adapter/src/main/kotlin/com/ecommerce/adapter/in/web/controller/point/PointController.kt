package com.ecommerce.adapter.`in`.web.controller.point

import com.ecommerce.adapter.`in`.web.dto.ApiResponse
import com.ecommerce.adapter.`in`.web.dto.point.PointResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class PointController: PointApiController {

    @GetMapping("/users/{userId}/points")
    override fun getPoint(@PathVariable userId: Long): ResponseEntity<ApiResponse<PointResponse>> {
        return ResponseEntity.ok(
            ApiResponse.success(PointResponse(1L, 10_000L))
        )
    }

    @PostMapping("/users/{userId}/points")
    override fun chargePoint(@PathVariable userId: Long): ResponseEntity<ApiResponse<PointResponse>> {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            ApiResponse.success(PointResponse(1L, 10_000L))
        )
    }
}