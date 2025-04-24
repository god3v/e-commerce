package com.ecommerce.adapter.`in`.web.controller.point

import com.ecommerce.adapter.`in`.web.dto.point.PointResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "Point", description = "포인트 관련 API")
@RequestMapping("/api/v1")
interface PointApiController {

    @Operation(summary = "포인트 조회", description = "사용자의 포인트 잔액을 조회합니다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "성공"),
            ApiResponse(responseCode = "404", description = "유효하지 않은 사용자 ID")
        ]
    )
    @GetMapping("/users/{userId}/points")
    fun getPoint(
        @Parameter(description = "조회할 사용자 ID", example = "1L")
        @PathVariable userId: Long
    ): ResponseEntity<com.ecommerce.adapter.`in`.web.dto.ApiResponse<PointResponse>>

    @Operation(summary = "포인트 충전", description = "사용자의 포인트를 충전합니다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "성공"),
            ApiResponse(responseCode = "400", description = "유효하지 않은 충전 금액"),
            ApiResponse(responseCode = "404", description = "유효하지 않은 사용자 ID")
        ]
    )
    @PostMapping("/users/{userId}/points")
    fun chargePoint(
        @Parameter(description = "충전할 사용자 ID", example = "1L")
        @PathVariable userId: Long
    ): ResponseEntity<com.ecommerce.adapter.`in`.web.dto.ApiResponse<PointResponse>>
}