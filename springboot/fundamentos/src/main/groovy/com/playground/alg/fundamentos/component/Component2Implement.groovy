package com.playground.alg.fundamentos.component

import org.springframework.stereotype.Component

@Component
class Component2Implement implements ComponentDependency {
    @Override
    void greetings() {
        println("Ahora estamos saludando desde el componente 2")
    }
}
