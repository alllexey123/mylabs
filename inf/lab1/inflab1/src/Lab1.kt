import java.math.BigDecimal
import java.math.BigInteger

fun main() {
    while (true) {
        print("Enter the number to convert (or 'exit'): ")
        val input = readlnOrNull() ?: break
        if (input.equals("exit", ignoreCase = true)) break

        try {
            println("Result: ${convert(input)}")
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
        }
    }
}

/**
 * Converts a number string from base 10 to base -10
 */
fun convert(input: String): String {
    if (input == "0" || input == "0.0") return "0"
    val num = input.toBigDecimalOrNull()
        ?: throw IllegalArgumentException("Invalid number format: $input")

    val whole = num.toBigInteger()
    val other = num - whole.toBigDecimal()
    val pow10 = (other.toString().length - other.toString().length % 2)
    var bigint = num.multiply(10.toBigDecimal().pow(pow10)).toBigInteger()

    var result = ""

    while (bigint != BigInteger.ZERO) {
        val remainder = modM10(bigint)
        result = remainder.toString() + result
        bigint = divM10(bigint)
    }

    val resBigDecimal = BigDecimal(result).multiply(BigDecimal("0.1").pow(pow10))
    val resStr = resBigDecimal.toPlainString()
    return if (resStr.contains('.')) resStr.trimEnd('0').trimEnd('.') else resStr
}

fun divM10(num: BigInteger): BigInteger {
    if (num >= BigInteger.ZERO || num % N_TEN == BigInteger.ZERO) {
        return num / N_TEN
    }
    return num / N_TEN + BigInteger.ONE
}

fun modM10(num: BigInteger): Int {
    val i = (num % N_TEN).toInt()
    return if (i >= 0) i else i + 10
}