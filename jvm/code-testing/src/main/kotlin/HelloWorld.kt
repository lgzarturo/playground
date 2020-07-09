
fun main(args: Array<String>) {
    println("Hola mundo")
    println(sum(17, 3))
    var age = 20
    println("La edad de $age es mayor que 18: ${graterAge(age)}")
    age = 16
    println("La edad de $age es mayor que 18: ${graterAge(age)}")

    val iphone = Product(name = "iPhone 11", price = 25000.00)
    val ipad = Product(name = "iPhone 11", price = 35000.00)
    println("El ${iphone.name} tiene un precio de \$${iphone.price} pesos.")
    println("iphone == ipad: ${iphone == ipad}")

    val client = Client(name = "Arturo")
    println("El cliente ${client.name}, ha solicitado el envió en la siguiente dirección: ${client.address}")
    if (client.address == "unknown") {
        client.address = null
    }
    if (client.address == null) {
        println("La dirección del cliente no se conoce.")
    }
}

fun sum(a: Int, b: Int) = a + b

fun graterAge(age: Int) = (age >= 18)

/**
 * Crear una clase producto y definir sus propiedades inmutables
 */
data class Product(val name:String, val price:Double) {
    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (other === this) return true
        if (this.javaClass != other.javaClass) return false
        other as Product
        return this.name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}

/**
 * Crear una clase cliente y definir sus propiedades variables y que acepten nulos
 */
class Client(var name:String, var address:String? = "unknown")