package com.playground.alg.fundamentos.bean

class CustomBean implements UnBean{
    @Override
    void printAction() {
        println("Realizamos una acción con el bean")
    }
}
