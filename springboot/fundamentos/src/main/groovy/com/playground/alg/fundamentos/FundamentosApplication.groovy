package com.playground.alg.fundamentos

import com.playground.alg.fundamentos.bean.BeanWithOperationDependency
import com.playground.alg.fundamentos.bean.BeanWithPropertiesDependency
import com.playground.alg.fundamentos.bean.UnBeanDependency
import com.playground.alg.fundamentos.component.ComponentDependency
import com.playground.alg.fundamentos.pojo.WebserviceProperties
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class FundamentosApplication implements CommandLineRunner {

    private Log log = LogFactory.getLog(this.class)

    private UnBeanDependency unBeanDependency
    private ComponentDependency componentDependency
    private BeanWithOperationDependency beanWithOperationDependency
    private BeanWithPropertiesDependency beanWithPropertiesDependency
    private WebserviceProperties webserviceProperties

    /**
     * @Qualifier indica el nombre de la dependencia que se quiere inyectar
     * @param componentDependency
     */
    FundamentosApplication(@Qualifier("component2Implement") ComponentDependency componentDependency,
                           UnBeanDependency unBeanDependency,
                           BeanWithOperationDependency beanWithOperationDependency,
                           BeanWithPropertiesDependency beanWithPropertiesDependency,
                           WebserviceProperties webserviceProperties) {
        this.componentDependency = componentDependency
        this.unBeanDependency = unBeanDependency
        this.beanWithOperationDependency = beanWithOperationDependency
        this.beanWithPropertiesDependency = beanWithPropertiesDependency
        this.webserviceProperties = webserviceProperties
    }

    static void main(String[] args) {
		SpringApplication.run(FundamentosApplication, args)
	}

    @Override
    void run(String... args) throws Exception {
        componentDependency.greetings()
        unBeanDependency.printAction()
        beanWithOperationDependency.printWithDependency()
        println(beanWithPropertiesDependency.function())
        println(webserviceProperties.toString())
        log.error("Este es un error en la aplicación")
    }
}
