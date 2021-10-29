package com.playground.alg.fundamentos

import com.playground.alg.fundamentos.bean.UnBeanDependency
import com.playground.alg.fundamentos.component.ComponentDependency
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class FundamentosApplication implements CommandLineRunner {

    private UnBeanDependency unBean
    private ComponentDependency componentDependency

    /**
     * @Qualifier indica el nombre de la dependencia que se quiere inyectar
     * @param componentDependency
     */
    FundamentosApplication(@Qualifier("component2Implement") ComponentDependency componentDependency, UnBeanDependency unBean) {
        this.componentDependency = componentDependency
        this.unBean = unBean
    }

    static void main(String[] args) {
		SpringApplication.run(FundamentosApplication, args)
	}

    @Override
    void run(String... args) throws Exception {
        componentDependency.greetings()
        unBean.printAction()
    }
}
