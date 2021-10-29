package com.playground.alg.fundamentos.bean

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

class BeanWithOperationImplement implements BeanWithOperationDependency{
    private Log log = LogFactory.getLog(this.class)

    private OperationDependency operationDependency

    BeanWithOperationImplement(OperationDependency operationDependency) {
        this.operationDependency = operationDependency
    }

    @Override
    void printWithDependency() {
        log.info("Estamos en el método printWithDependency")
        def number = 10
        def total = operationDependency.sum(number)
        log.debug("El resultado de la suma del número ${number} es ${total}")
        println("Implementación con un bean de dependencia - SUM:${total}")
    }
}
