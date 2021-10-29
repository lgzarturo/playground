package com.playground.alg.fundamentos.configuration

import com.playground.alg.fundamentos.bean.Custom2BeanImplement
import com.playground.alg.fundamentos.bean.UnBeanDependency
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ConfigurationBean {
    @Bean
    UnBeanDependency beanDependency() {
        return new Custom2BeanImplement()
    }
}
