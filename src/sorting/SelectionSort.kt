package sorting

class  SelectionSort {

    fun sort(list : IntArray) {
        for (i in list.indices) {
            // We assume that smallest element of the array is present at this index.
            var smallestElementAtIndex = i

            // This iteration ensures that if there is an element which smaller than
            // the element kept at [smallestElementAtIndex] so update its index to smallestElementAtIndex.
            for (j in i+1..<list.size) {
                if (list[j] < list[smallestElementAtIndex]) {
                    smallestElementAtIndex = j
                }
            }
            // values get swapped here by indexes.
            val temp = list[i]
            list[i] = list[smallestElementAtIndex]
            list[smallestElementAtIndex] = temp
        }
    }
}