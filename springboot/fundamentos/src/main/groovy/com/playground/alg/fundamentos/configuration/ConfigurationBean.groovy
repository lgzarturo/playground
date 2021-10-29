package com.playground.alg.fundamentos.configuration

import com.playground.alg.fundamentos.bean.Custom2Bean
import com.playground.alg.fundamentos.bean.UnBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ConfigurationBean {
    @Bean
    UnBean beanOperation() {
        return new Custom2Bean()
    }
}
