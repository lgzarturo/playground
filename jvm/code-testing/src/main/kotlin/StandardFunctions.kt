
fun main() {
    test()
}


fun test() {
    var info = "Hello world"
    run {
        val info = "Hola cancun"
        println(info)
    }
    with(info) {
        if (info == "Hello world") {
            println("Hola mundo")
        }
    }
    for (i in 0..10) {
        var test: String? = if (i%2 == 0) {
            "Hola"
        } else {
            null
        }
        test?.let { greeting -> println("El saludo de la persona numero $i es $greeting") }
    }

    println("\nSaludo con let")
    info.let {
        println("El saludo original es $it")
        it.reversed()
    }.let {
        println("El saludo original en reversa es $it")
        it.length
    }.let {
        println("El tamaño del saludo original es $it")
    }

    println("\nSaludo con also")
    info.also {
        println("El saludo original es $it")
    }.also {
        println("El saludo original en reversa es ${it.reversed()}")
    }.also {
        println("El tamaño del saludo original es ${it.length}")
    }

    println("\nSaludo con let y also")
    info.let { it.reversed() }.also { println(it.toUpperCase().reversed()) }

    val personGreeting = greeting("Arturo López", "Hola Mundo")
    println("${personGreeting.name}: ${personGreeting.greeting}")
    println(info)
}

fun greeting(personName: String, personGreeting: String) = Greeting()
        .apply { name = personName  }
        .apply { greeting = personGreeting }

class Greeting {
    var name: String? = null
    var greeting: String? = null
}
