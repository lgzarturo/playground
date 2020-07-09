
import java.lang.NumberFormatException
import kotlin.math.roundToInt

class TryCatchExample() {
    private fun usingAsExpression(inputValue: String): Number {
        return try {
            return invokeLibWith(inputValue)
        } catch (ex: NumberFormatException) {
            1
        }
    }

    private fun invokeLibWith(constantAsString: String): Number {
        return Integer.valueOf(constantAsString)
    }

    fun isNumber(value: Any?): Number? = when (value) {
        null -> throw IllegalArgumentException("No se puede procesar el valor nulo")
        is String -> {
            rangeInt(usingAsExpression(value).toInt())
        }
        is Int -> rangeInt(value)
        is Float -> rangeInt(value.roundToInt())
        is Double -> rangeInt(value.roundToInt())
        is Long -> rangeInt(value.toInt())
        else -> throw IllegalArgumentException("El valor $value, no se puede convertir")
    }

    private fun rangeInt(value: Int?): Int = when (value) {
        null -> throw IllegalArgumentException("value supplied is null")
        in 0..60000 -> value
        else -> throw IllegalArgumentException("El valor se sale del rango permitido entre 0 y 60000")
    }
}

fun main() {
    val app = TryCatchExample()
    var dataString = "10000"
    var dataNumber = app.isNumber(dataString)
    var result = 100 * dataNumber!!.toInt()
    println("Convertir la cadena $dataString en número: 100*$dataNumber = $result")
    dataString = "abc10000"
    dataNumber = app.isNumber(dataString)
    result = 100 * dataNumber!!.toInt()
    println("Convertir la cadena $dataString en numero: 100*$dataNumber = $result")
}
