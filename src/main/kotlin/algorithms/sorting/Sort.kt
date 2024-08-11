package algorithms.sorting

class  Sort {

    fun selectionSort(list : IntArray) {
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

     fun mergeSort(arr : IntArray, low : Int, high : Int) {
        if (low >= high) {
            return
        }
        var mid = low + (high - low) / 2
        mergeSort(arr, low, mid)
        mergeSort(arr, mid+1, high)
        merge(arr, low, mid, high)
    }
    private fun merge(arr: IntArray, low : Int, mid : Int, high: Int) {
        var list = mutableListOf<Int>()
        var left = low
        var right = mid + 1
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left])
                left++
            }else {
                list.add(arr[right])
                right++
            }
        }

        while (left <= mid) {
            list.add(arr[left])
            left++
        }

        while (right <= high) {
            list.add(arr[right])
            right++
        }

        for (i in low..high) {
            arr[i] = list[i - low]
        }
    }
}
