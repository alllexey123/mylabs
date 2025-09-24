package api.myitmo

import java.math.BigDecimal
import java.math.BigInteger
import java.util.Scanner

val m10 = (-10).toBigInteger()

fun main() {
    // b_10 => b_-10
    val scanner = Scanner(System.`in`)
    while (true) {
        print("Enter the number to convert: ")
        val numStr = scanner.next()
        try {
            println("Result: ${calc(numStr)}")
        } catch (e: Exception) {
            println("Invalid number: ${e.message}")
        }
    }
}

const val allowedChars = "0123456789.-"

fun calc(numStr: String): String {
    // input validation
    if (numStr == "0" || numStr == "0.0") return "0"
    if (numStr.any { c -> !allowedChars.contains(c) }) {
        throw RuntimeException("Input contains characters other than $allowedChars")
    }
    if (numStr.count { c -> c == '.' } > 1 || numStr.indexOf('.') in listOf(0, numStr.lastIndex)) {
        throw RuntimeException("Input contains multiple or misplaced '.'")
    }
    if (numStr.startsWith("-") && numStr.lastIndexOf('-') > 0) {
        throw RuntimeException("Input contains multiple or misplaced '-'")
    }

    val num = numStr.toBigDecimal()
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
    if (num >= BigInteger.ZERO || num % m10 == BigInteger.ZERO) {
        return num / m10
    }
    return num / m10 + BigInteger.ONE
}

fun modM10(num: BigInteger): Int {
    val i = (num % m10).toInt()
    return if (i >= 0) i else i + 10
}
