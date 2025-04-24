package com.ecommerce.adapter.`in`.web.controller.item

import com.ecommerce.adapter.`in`.web.dto.item.ItemResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "Coupon", description = "쿠폰 관련 API")
@RequestMapping("/api/v1/items")
interface ItemApiController {

    @Operation(summary = "상품 목록 조회", description = "상품 목록을 조회합니다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "성공")
        ]
    )
    @GetMapping
    fun getItems(): ResponseEntity<com.ecommerce.adapter.`in`.web.dto.ApiResponse<List<ItemResponse>>>

    @Operation(summary = "인기 상품 목록 조회", description = "인기 상품 목록을 조회합니다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "성공")
        ]
    )
    @GetMapping("/popular")
    fun getPopularItems(): ResponseEntity<com.ecommerce.adapter.`in`.web.dto.ApiResponse<List<ItemResponse>>>

}