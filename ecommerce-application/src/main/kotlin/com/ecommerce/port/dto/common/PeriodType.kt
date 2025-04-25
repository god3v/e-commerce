package com.ecommerce.port.dto.common

enum class PeriodType(val days: Long) {
    DAILY(1),
    WEEKLY(7),
    MONTHLY(30),
    YEARLY(365)
}