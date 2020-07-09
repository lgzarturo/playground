package com.models

class Account {
    String person
    Double quantity

    Account(String person, Double quantity = 0) {
        this.person = person
        this.quantity = quantity
    }

    def add(Double quantity) {
        if (quantity > 0) {
            this.quantity += quantity
        }
    }

    def subtract(Double quantity) {
        if (quantity >= this.quantity) {
            this.quantity = 0
        } else {
            this.quantity -= quantity
        }
    }


    @Override
    String toString() {
        return "El titular ${this.person} tiene el siguiente ahorro \$${this.quantity} MXN"
    }
}
