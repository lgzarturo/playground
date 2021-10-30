package com.playground.alg.fundamentos.configuration

import com.playground.alg.fundamentos.bean.BeanWithOperationDependency
import com.playground.alg.fundamentos.bean.BeanWithOperationImplement
import com.playground.alg.fundamentos.bean.Custom2BeanImplement
import com.playground.alg.fundamentos.bean.OperationDependency
import com.playground.alg.fundamentos.bean.OperationImplement
import com.playground.alg.fundamentos.bean.UnBeanDependency
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

import javax.sql.DataSource

@Configuration
@PropertySource("classpath:connection.properties")
class ConfigurationBean {
    @Value("\${db.url}")
    private String jdbcUrl
    @Value("\${db.driver}")
    private String driver
    @Value("\${db.username}")
    private String username
    @Value("\${db.password}")
    private String password

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

   @Bean
    DataSource dataSource() {
       DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create()
       dataSourceBuilder.driverClassName(driver)
       dataSourceBuilder.url(jdbcUrl)
       dataSourceBuilder.username(username)
       dataSourceBuilder.password(password)
       dataSourceBuilder.build()
   }
}
