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
    println("*******************operations starts on string***********************")
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
    println("*******************operations ends on string***********************")

    var wholeNumberArray = Array<Int>(10) { it }
    with(wholeNumberArray) {
        println(wholeNumberArray.contentToString())
        println(average()) // returns the average of the array
        println(count()) // returns the total count
        println(count { it > 0 }) // returns total count where this predicate gives true
        println(first()) // returns the first element of the array
        println(first { it > 6 }) // gives the first element where this predicate gives true
        forEachIndexed { index, it -> print("$index and $it") } // like forEach function
        println()

        // print distinct number
        println(distinct()) // prints the distinct element
        println(distinctBy { it > 5 }) // distinct the element by given predicate
        println(drop(5)) // drop first n element and return the list
        println(dropLast(5)) // drop last n element and return the list

        println(dropWhile { it % 2 == 0 })
        println(dropLastWhile { it % 2 == 0 })

        println(elementAt(0)) // returns the element at given index if index is out of bound then throws the exception
        println(elementAtOrElse(20) { -1 }) // returns the element at given index if index is out of bound then return default value.
        println(elementAtOrNull(20)) // return the element at the given index if index is out of bound then return null

        val matrix = IntArray(10).apply { fill(-1) } // fill method fills the array with given value.
        println(matrix.contentToString())

        println(filter { it % 2 == 0 }) // returns the list of elements where this predicate return true
        println(filterIndexed { index, i -> i % 2 != 0 }) // with this function we can access the index
    }

    val newWholeNumberArray = wholeNumberArray.copyOf(20)
    with(newWholeNumberArray) {
        println(filterNotNull().filterNot { it < 8 }) // removes all null value from array then includes those values which
        // are not matching with this predicate.

        println(find { it == 7 }) // return the first element matching the given predicate.
        println(findLast { it == 8 })

        println(last())
        println(last { it == 9 })

        println(indexOf(2))
        println(indexOfFirst { it == 5 })
        println(indexOfLast { it == 7 })

        println(filterNotNull().firstNotNullOf { it > 100 })
        println(filterNotNull().firstNotNullOfOrNull { it > 100 })

        println(filterNotNull().fold(0) { acc, item -> acc + item })

        println(getOrElse(20) { -1 })
        println(getOrNull(20))
        println(filterNotNull().groupBy { it % 2 == 0 })

        println(intersect(listOf(1, 2, 4)))
        println(isArrayOf<Int>())


        println(joinToString())
        println(lastIndexOf(1))
        println(map { "$it * 1" })

        println(filterNotNull().max())
        println(filterNotNull().maxBy { it > 8 })
        println(filterNotNull().maxOf { it > 8 })

        println(filterNotNull().min())
        println(filterNotNull().minBy { it > 8 })
        println(filterNotNull().minOf { it > 8 })

        println(filterNotNull().partition { it % 2 == 0 })

        println(plus(1).contentToString())
        println(random())
        println(reversed())
        shuffle()
        println(contentToString())
        println(slice(4..9))
    }

    val arrayOfArray = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6))
    println(arrayOfArray.flatMap { it.toList() })
    println(arrayOfArray.flatten())

    val flattenList = arrayOfArray.flatten()

    println(flattenList.sorted())
    println(flattenList.sortedDescending())
    println(flattenList.sortedWith(comparator = { o1, o2 -> if (o1 > o2) 1 else -1 }))
    with(flattenList) {
        println(sum())
        println(take(5))
        println(takeLast(5))
    }

   // Converting from Array<T> to tArrayOf
    //toList
    //toMap
    //toMutableList
    //toMutableSet
    //toSet
    //toSortedSet
    //union
}