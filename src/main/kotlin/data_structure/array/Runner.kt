package data_structure.array


fun main() {

    val arrayOfString = arrayOf("one", "two")
    val emptyArray = emptyArray<String>()
    val arrayOfNulls = arrayOfNulls<String>(10)

    val intArray = intArrayOf() // IntArray
    val booleanArray = booleanArrayOf() // BooleanArray
    val floatArray = floatArrayOf() // FloatArray
    val doubleArray = doubleArrayOf() // DoubleArray
    val longArray = longArrayOf() // LongArray
    val shortArray = shortArrayOf() //ShortArray

    val stringArray = Array<String>(10) { "Mohit" }

    // Main properties of the Array class
    with(stringArray) {
        println(indices)
        println(size)
        println(this.get(0))
        println(this[0])
        this.set(0, "Update At Index 0")
        this[1] = "Update at index 1"
    }

    // Extensions function on the Array class
    with(stringArray) {
        println(all { it.length > 10 })
        println(any { it.length >= 5 })
        println(this.asList())

        println(associate { Pair(it, it.length) })
        println(associateTo(mutableMapOf<String, Int>()) { Pair(it, it.length) })

        println(associateBy { it.length })
        println(associateBy({ it }) { it.length })
        println(associateByTo(destination = mutableMapOf(), { it }))

        println(associateWith { it.length * 10 })
        println(associateWithTo(mutableMapOf(), { it.length }))

        println(first())
        println(lastIndex)

        println(contains("Mohit"))

        println(contentDeepToString())
        println(contentToString())

        var newStringArray = Array<String>(10) { "" }
        newStringArray = copyInto(newStringArray)
        println("new array : ${newStringArray.contentToString()}")

        val newCopyOfArray = copyOf(20)
        println("new copy of array : ${newCopyOfArray.contentToString()}")

        val newCopyOfRangeArray = copyOfRange(2, 6)
        println("new copy of range array : ${newCopyOfRangeArray.contentToString()}")
    }

    val wholeNumberArray = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    with(wholeNumberArray) {

    }
}