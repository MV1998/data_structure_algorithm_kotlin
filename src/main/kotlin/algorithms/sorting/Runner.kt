package algorithms.sorting

fun main() {
    val selectionSort = Sort()
    var list = intArrayOf(1, 0, 3, 4, 2)
//    selectionSort.selectionSort(list)
//    for (element in list) {
//        print("$element ")
//    }
    var arrToBeSorted = intArrayOf(1, 0, 3, 4, 2)
    selectionSort.mergeSort(arrToBeSorted, 0, arrToBeSorted.size-1)
//    arrToBeSorted.sortDescending()
    for (i in arrToBeSorted) {
        print("$i ")
    }
    println()
}