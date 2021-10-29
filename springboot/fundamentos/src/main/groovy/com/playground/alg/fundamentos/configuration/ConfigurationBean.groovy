package com.playground.alg.fundamentos.configuration

import com.playground.alg.fundamentos.bean.BeanWithOperationDependency
import com.playground.alg.fundamentos.bean.BeanWithOperationImplement
import com.playground.alg.fundamentos.bean.Custom2BeanImplement
import com.playground.alg.fundamentos.bean.OperationDependency
import com.playground.alg.fundamentos.bean.OperationImplement
import com.playground.alg.fundamentos.bean.UnBeanDependency
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ConfigurationBean {
    @Bean
    UnBeanDependency beanDependency() {
        return new Custom2BeanImplement()
    }

    @Bean
    OperationDependency beanOperation() {
        return new OperationImplement()
    }

    @Bean
    BeanWithOperationDependency beanOperationWithDependency(OperationDependency operationDependency) {
        return new BeanWithOperationImplement(operationDependency)
    }
}
