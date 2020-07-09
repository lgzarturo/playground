package com

import com.models.Account
import com.models.Person

static main(def args) {
    println "Hola mundo"
    println sum(14, 12)
    def age = 19
    println "La edad de $age es mayor de 18 años: ${graterAge(age)}"
    age = 16
    println "La edad de $age es mayor de 18 años: ${graterAge(age)}"

    def account = new Account("Arturo")
    println account
    account.add(3992.29)
    println account
    account.subtract(2.29)
    println account

    def firstPerson = new Person("Arturo", 36, "H", 1.73, 83)
    def secondPerson = new Person("Karina", 37, "M", 1.60, 70)
    def thirdPerson = new Person("Gustavo", 6, "H", 1.10, 20)
    def fourthPerson = new Person("Daniela", 4, "M", 1.00, 16)

    println firstPerson
    println secondPerson
    println thirdPerson
    println fourthPerson
}

def static sum(a, b) {
    a + b
}

def static graterAge(age) {
    (age >= 18)
}
