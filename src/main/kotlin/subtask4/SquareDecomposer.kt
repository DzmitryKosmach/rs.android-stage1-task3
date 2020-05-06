package subtask4

class SquareDecomposer {
    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 0) return null
        val numberLong = number.toLong()
        val numberSquared = numberLong * numberLong
        var list = mutableListOf<Long>()
        var temp = numberLong - 1
        var shift = 1
        loop@ while (numberSquared != list.map { it * it }.sum()) {
            for (i in temp downTo 1) {
                var sum = list.map { it * it }.sum() + (i * i)
                if (sum <= numberSquared) {
                    list.add(i)
                }
                if (list.map { it * it }.sum() == numberSquared) {
                    break@loop
                }
            }
            if (list.size <= 1) return null
            if (list.map { it * it }.sum() != numberSquared) {
                val lastIndex = list.lastIndex
                if (list[lastIndex] == 1L && list[lastIndex - 1] == 2L && (lastIndex - shift) < 4) {
                    temp = list[1] - 1
                    list = list.subList(0, 1)
                } else {
                    ++shift
                    if(list[shift] > 67) ++shift
                    temp = list[shift] - 1
                    list = list.subList(0, shift)
                }
            }
        }
        list.reverse()
        return if (list.isNotEmpty()) list.map { it.toInt() }.toTypedArray() else null

    }
}
