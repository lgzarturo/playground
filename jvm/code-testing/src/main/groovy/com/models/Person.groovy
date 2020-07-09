package com.models

class Person {
    String name
    Integer age
    String dni
    String gender
    Double height
    Double weight

    Person(String name, Integer age, String gender) {
        this.name = name
        this.age = age
        this.gender = gender
        this.dni = generateDni()
        this.height = 0
        this.weight = 0
    }

    Person(String name, Integer age = 0, String gender = "H", Double height = 0, Double weight) {
        this.name = name
        this.dni = generateDni()
        this.gender = gender
        this.height = height
        this.weight = weight
        this.age = age
    }

    def getIMC() {
        def imc = this.weight / (Math.pow(this.height, 2))
        if (imc < 20) {
            return -1
        } else if (imc >= 20 && imc <= 25) {
            return 0
        } else {
            return 1
        }
    }

    def isAdult() {
        this.age >= 18
    }

    def generateDni() {
        def dni = []
        int total = 0
        1..8.each {
            dni << new Random().nextInt().abs()

            total += dni
        }
        total = (int) (total / 23)
        dni << (total as char)
        this.dni = dni.join("")
    }

    @Override
    String toString() {
        def message = []
        if (this.isAdult()) {
            message << "Es Mayor de edad."
        } else {
            message << "Es Menor de edad, no ha cumplido 18 años, le faltan ${18 - this.age} años."
        }
        if (this.IMC == 1) {
            message << "Tiene sobre peso."
        }
        if (this.IMC == 0) {
            message << "Esta justo por debajo de su peso ideal."
        }
        if (this.IMC == -1) {
            message << "Esta bajo de peso."
        }

        return "${this.name} con el DNI ${this.dni}:\n\t${message.join("\n\t")}\n"
    }
}
