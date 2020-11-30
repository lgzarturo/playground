package com


static main(def args) {
    def days = 4
    def enabledDays = (0..<days).collect {
        it
    }
    println(enabledDays)

}

