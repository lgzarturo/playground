package com.playground.alg.fundamentos.component

import org.springframework.stereotype.Component

@Component
class ComponentImplement implements ComponentDependency {
    @Override
    void greetings() {
        println("Hola mundo desde componentImplement")
    }
}
