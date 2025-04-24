package com.ecommerce.adapter.`in`.web.controller.item

import com.ecommerce.adapter.`in`.web.dto.ApiResponse
import com.ecommerce.adapter.`in`.web.dto.item.ItemResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/items")
class ItemController: ItemApiController {

    @GetMapping
    override fun getItems(): ApiResponse<List<ItemResponse>> {
        return ApiResponse.success(
            listOf(
                ItemResponse(
                    1L,
                    "상품명",
                    30000,
                    "SELLING",
                    3
                )
            )
        )
    }

    @GetMapping("/popular")
    override fun getPopularItems(): ApiResponse<List<ItemResponse>> {
        return ApiResponse.success(
            listOf(
                ItemResponse(
                    1L,
                    "상품명",
                    30000,
                    "SELLING",
                    3
                )
            )
        )
    }
}