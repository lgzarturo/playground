package com.playground.alg.fundamentos.configuration

import com.playground.alg.fundamentos.bean.BeanWithPropertiesDependency
import com.playground.alg.fundamentos.bean.BeanWithPropertiesImplement
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GeneralConfiguration {
    @Value("\${app.name}")
    String name
    @Value("\${app.action}")
    String action
    @Value("\${app.random}")
    String random

    @Bean
    BeanWithPropertiesDependency function() {
        return new BeanWithPropertiesImplement(name, action)
    }
}
