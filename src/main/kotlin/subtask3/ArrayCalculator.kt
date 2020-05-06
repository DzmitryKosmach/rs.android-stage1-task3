package subtask3

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var result = 1
        val resultList = mutableListOf<Int>()
        val n = if (itemsFromArray.size < numberOfItems) itemsFromArray.size else numberOfItems
        for (i in 1..n) {
            maxPositiveItem(itemsFromArray, resultList)
        }
        minNegativeItem(itemsFromArray, resultList, numberOfItems)
        if (resultList.size != 0) {
            for (n in resultList) {
                result *= n
            }
        } else result = 0
        return result
    }

    private fun maxPositiveItem(itemsFromArray: Array<Any>, resultList: MutableList<Int>) {
        var max = 0
        var indexMax = 0
        for (i in itemsFromArray.indices) {
            if (itemsFromArray[i] is Int) {
                if (itemsFromArray[i] as Int > max) {
                    max = itemsFromArray[i] as Int
                    indexMax = i
                }
            }
        }
        if (max != 0) {
            resultList.add(max)
            itemsFromArray[indexMax] = ""
        }
    }

    private fun minNegativeItem(itemsFromArray: Array<Any>, resultList: MutableList<Int>, numberOfItems: Int) {
        var min1 = 0
        var indexMin1 = 0
        var min2 = 0
        var indexMin2 = 0
        for (i in itemsFromArray.indices) {
            if (itemsFromArray[i] is Int) {
                if ((itemsFromArray[i] as Int) < min1) {
                    min1 = itemsFromArray[i] as Int
                    indexMin1 = i
                }
            }
        }
        if (min1 != 0) {
            itemsFromArray[indexMin1] = ""
        }
        for (i in itemsFromArray.indices) {
            if (itemsFromArray[i] is Int) {
                if ((itemsFromArray[i] as Int) < min2) {
                    min2 = itemsFromArray[i] as Int
                    indexMin2 = i
                }
            }
        }
        if (min2 != 0) {
            itemsFromArray[indexMin2] = ""
        }

        if (min1 != 0 && min2 != 0) {
            if (min1 * min2 > resultList[resultList.size - 1] * resultList[resultList.size - 2]) {
                resultList[resultList.size - 1] = min1
                resultList[resultList.size - 2] = min2
            }
        } else if (min1 != 0 && resultList.size < numberOfItems){
            resultList.add(min1)
        }
    }
}
