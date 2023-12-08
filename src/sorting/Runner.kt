package sorting

fun main() {
    val selectionSort = SelectionSort()
    var list = intArrayOf(3,1)
    selectionSort.sort(list)
    for (element in list) {
        print("$element ")
    }
    println()
}