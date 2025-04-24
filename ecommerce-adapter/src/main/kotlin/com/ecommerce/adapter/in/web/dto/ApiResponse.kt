package com.ecommerce.adapter.`in`.web.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "공통 API 응답 모델")
data class ApiResponse<T>(
    @field:Schema(description = "성공 여부", type = "Boolean", example = "true")
    val success: Boolean,
    @field:Schema(description = "응답 데이터", type = "Object")
    val data: DataWrapper<T>? = null,
    @field:Schema(description = "에러 메시지", type = "String")
    val errorMessage: String? = null
) {

    data class DataWrapper<T>(
        @field:Schema(description = "응답 데이터 내용", type = "Object")
        val content: T,
        @field:Schema(description = "페이징", type = "Object")
        val pagination: Pagination? = null
    )

    data class Pagination(
        @field:Schema(description = "현재 페이지", type = "Object")
        val page: Int,
        @field:Schema(description = "페이지별 데이터 수", type = "Int")
        val size: Int,
        @field:Schema(description = "전체 페이지 수", type = "Int")
        val totalPages: Int,
        @field:Schema(description = "전체 데이터 수", type = "Long")
        val totalElements: Long
    )

    companion object {
        fun <T> success(content: T, pagination: Pagination? = null): ApiResponse<T> =
            ApiResponse(
                success = true,
                data = DataWrapper(content, pagination),
                errorMessage = null
            )

        fun <T> failure(content: T, errorMessage: String? = null): ApiResponse<T> =
            ApiResponse(
                success = false,
                data = null,
                errorMessage = errorMessage
            )
    }
}
