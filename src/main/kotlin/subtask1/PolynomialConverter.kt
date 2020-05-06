package subtask1

import kotlin.math.absoluteValue

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) return null
        val result = StringBuilder()
        val indexSize = numbers.size - 1
        for (i in numbers.indices) {
            val currentNumber = numbers[i]
            if (currentNumber == 0) continue
            var firstOperator = ""
            var operator = ""
            var number = ""
            var x = ""
            var operatorDegree = ""
            var numberDegree = ""
            if (i == 0) {
                firstOperator = if (currentNumber > 0) "" else "-"
            } else {
                operator = if (currentNumber > 0) " + " else " - "
            }
            if (indexSize > i) {
                x = "x"
                if (currentNumber.absoluteValue > 1) number = currentNumber.absoluteValue.toString()
                if (indexSize - i  > 1) {
                    operatorDegree = "^"
                    numberDegree = (indexSize - i).toString()
                }
            } else number = currentNumber.toString()
            result.append("$firstOperator$operator$number$x$operatorDegree$numberDegree")
        }
        return result.toString()
    }
}
