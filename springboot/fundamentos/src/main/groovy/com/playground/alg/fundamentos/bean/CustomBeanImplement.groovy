package com.playground.alg.fundamentos.bean

class CustomBeanImplement implements UnBeanDependency{
    @Override
    void printAction() {
        println("Realizamos una acción con el bean")
    }
}
