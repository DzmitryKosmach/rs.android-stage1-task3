package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val m = array[0]
        val n = array[1]
        var combinations = 0
        while (true) {
            combinations++
            if ( combinations > n) return null
            val countCombinations = getCombinations(n, combinations)
            if ( countCombinations == m) return combinations
        }
    }

    private fun getCombinations(n: Int, k: Int): Int {
        return (factorial(n) / (factorial(k) * factorial(n - k))).toInt()
    }

    private fun factorial(num: Int): Long {
        if (num >= 1)
            return num * factorial(num - 1)
        else
            return 1
    }
}
