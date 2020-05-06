package subtask5

import kotlin.reflect.KClass

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val neighbours = mapOf(
            '0' to setOf('8'),
            '1' to setOf('2', '4'),
            '2' to setOf('1', '3', '5'),
            '3' to setOf('2', '6'),
            '4' to setOf('1', '5', '7'),
            '5' to setOf('2', '4', '6', '8'),
            '6' to setOf('3', '5', '9'),
            '7' to setOf('4', '8'),
            '8' to setOf('5', '7', '9', '0'),
            '9' to setOf('6', '8')
        )
        val listNumbers = mutableListOf<String>()
        if (number.toInt() < 0 ) return null
        for (i in number.indices) {
            val numberSB = StringBuilder(number)
            val nNumbers = neighbours[numberSB[i]]
            for (n in nNumbers!!){
                numberSB[i] = n
                listNumbers.add(numberSB.toString())
            }
        }
        return listNumbers.toTypedArray()
    }
}
