package com.ecommerce.adapter

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = [
    "com.ecommerce"
])
class ServerConfig {
}