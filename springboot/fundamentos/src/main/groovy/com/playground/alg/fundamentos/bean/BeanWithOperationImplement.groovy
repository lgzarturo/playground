package com.playground.alg.fundamentos.bean

class BeanWithOperationImplement implements BeanWithOperationDependency{
    private OperationDependency operationDependency

    BeanWithOperationImplement(OperationDependency operationDependency) {
        this.operationDependency = operationDependency
    }

    @Override
    void printWithDependency() {
        println("Implementación con un bean de dependencia - SUM:${operationDependency.sum(10)}")
    }
}
