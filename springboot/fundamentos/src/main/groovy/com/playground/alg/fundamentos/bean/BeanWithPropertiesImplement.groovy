package com.playground.alg.fundamentos.bean

class BeanWithPropertiesImplement implements BeanWithPropertiesDependency {

    private String name
    private String action

    BeanWithPropertiesImplement(String name, String action) {
        this.name = name
        this.action = action
    }

    @Override
    String function() {
        return "${this.name} - ${this.action}"
    }
}
