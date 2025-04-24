package com.ecommerce.adapter.`in`.web.dto

data class ApiResponse<T>(
    val success: Boolean,
    val data: DataWrapper<T>? = null,
    val errorMessage: String? = null
) {

    data class DataWrapper<T>(
        val content: T,
        val pagination: Pagination? = null
    )

    data class Pagination(
        val page: Int,
        val size: Int,
        val totalPages: Int,
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
