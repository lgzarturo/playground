package com.playground.alg.fundamentos.bean

class OperationImplement implements OperationDependency {

    @Override
    int sum(int number) {
        return number+1
    }
}
