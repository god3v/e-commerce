package com.ecommerce.adapter.`in`.web.controller.item

import com.ecommerce.adapter.`in`.web.dto.ApiResponse
import com.ecommerce.adapter.`in`.web.dto.item.ItemResponse
import com.ecommerce.port.dto.common.PeriodType
import com.ecommerce.port.`in`.item.GetItemUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/items")
class ItemController(
    private val getItemUseCase: GetItemUseCase
) : ItemApiController {

    @GetMapping
    override fun getItems(): ApiResponse<List<ItemResponse>> {
        val results = getItemUseCase.getItems()
        return ApiResponse.success(results.map { ItemResponse.of(it) })
    }

    @GetMapping("/popular")
    override fun getPopularItems(@RequestParam period: PeriodType): ApiResponse<List<ItemResponse>> {
        val results = getItemUseCase.getPopularItems(period)
        return ApiResponse.success(results.map { ItemResponse.of(it) })
    }
}