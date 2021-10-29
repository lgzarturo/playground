package com.playground.alg.fundamentos

import com.playground.alg.fundamentos.component.ComponentDependency
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class FundamentosApplication implements CommandLineRunner {

    private ComponentDependency componentDependency

    FundamentosApplication(ComponentDependency componentDependency) {
        this.componentDependency = componentDependency
    }

    static void main(String[] args) {
		SpringApplication.run(FundamentosApplication, args)
	}

    @Override
    void run(String... args) throws Exception {
        componentDependency.greetings()
    }
}
