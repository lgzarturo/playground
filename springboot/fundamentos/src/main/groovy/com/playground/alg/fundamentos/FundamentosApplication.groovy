package com.playground.alg.fundamentos

import com.playground.alg.fundamentos.bean.BeanWithOperationDependency
import com.playground.alg.fundamentos.bean.BeanWithPropertiesDependency
import com.playground.alg.fundamentos.bean.UnBeanDependency
import com.playground.alg.fundamentos.component.ComponentDependency
import com.playground.alg.fundamentos.model.User
import com.playground.alg.fundamentos.pojo.WebserviceProperties
import com.playground.alg.fundamentos.repository.UserRepository
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

import java.time.LocalDate

@SpringBootApplication
class FundamentosApplication implements CommandLineRunner {

    private Log log = LogFactory.getLog(this.class)

    private UnBeanDependency unBeanDependency
    private ComponentDependency componentDependency
    private BeanWithOperationDependency beanWithOperationDependency
    private BeanWithPropertiesDependency beanWithPropertiesDependency
    private WebserviceProperties webserviceProperties
    private UserRepository userRepository

    /**
     * @Qualifier indica el nombre de la dependencia que se quiere inyectar
     * @param componentDependency
     */
    FundamentosApplication(@Qualifier("component2Implement") ComponentDependency componentDependency,
                           UnBeanDependency unBeanDependency,
                           BeanWithOperationDependency beanWithOperationDependency,
                           BeanWithPropertiesDependency beanWithPropertiesDependency,
                           WebserviceProperties webserviceProperties,
                           UserRepository userRepository) {
        this.componentDependency = componentDependency
        this.unBeanDependency = unBeanDependency
        this.beanWithOperationDependency = beanWithOperationDependency
        this.beanWithPropertiesDependency = beanWithPropertiesDependency
        this.webserviceProperties = webserviceProperties
        this.userRepository = userRepository
    }

    static void main(String[] args) {
		SpringApplication.run(FundamentosApplication, args)
	}

    @Override
    void run(String... args) throws Exception {
        dependencyExamples()
        saveUsers()
    }

    private void saveUsers() {
        def users = []
        (1..10).each {
            users << new User(
                username: "lgzarturo_${it}",
                email: "lgzarturo_${it}@gmail.com",
                password: '12345',
                birthDate: LocalDate.of(2021, 10, 29)
            )
        }
        users.forEach(userRepository::save)
    }

    private void dependencyExamples() {
        componentDependency.greetings()
        unBeanDependency.printAction()
        beanWithOperationDependency.printWithDependency()
        println(beanWithPropertiesDependency.function())
        println(webserviceProperties.toString())
        log.error("Este es un error en la aplicación")
    }
}
