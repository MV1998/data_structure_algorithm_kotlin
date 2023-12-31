package binary_search

/*
Kotlin | Java | Retrofit | OkHttp | Coroutines | Picasso | Glide | HILT | Room SQLite | MVVM Pattern | Google API Integration |Third Party Library/API Integration | Design Patterns | UI Customization | MDC (Material Design Component) | Constraint Layout | Motion Layout | Android Jetpack Components | Firebase | Koin | Ktor
 */

fun main() {
//    println(binarySearch(intArrayOf(1,2,3,4,5,6,7,8,9,10), 6))
//    println(recursiveBinarySearch(intArrayOf(1,2,3,4,5,6,7,8,9,10), 6, 0, 9))
//    println(lowerBound(intArrayOf(1,2,3,3,5,8,8,10,10,11), 8))
//    println(upperBound(intArrayOf(1,2,3,3,5,8,8,10,10,11), 8))

    var floorAndCeil = ceilAndFloor(intArrayOf(3,4,4,7,8,10), 8)
    println(floorAndCeil[0])
    println(floorAndCeil[1])
}

fun binarySearch(arr : IntArray, target : Int) : Int {
    var low = 0
    var high = arr.size-1

    while (low <= high) {
        var mid = (low + high) / 2
        if (arr[mid] == target) {
            return mid
        }else if (target < arr[mid]) {
            high = mid - 1
        }else {
            low = mid + 1
        }
    }
    return -1
}

fun recursiveBinarySearch(arr : IntArray, target: Int, low : Int, high : Int) : Int {
    if (low > high) return -1

    var mid = (low + high) / 2
    if (arr[mid] == target) {
        return mid
    } else if (target < arr[mid]) {
        return recursiveBinarySearch(arr, target, low, mid - 1)
    }
    return recursiveBinarySearch(arr, target, mid + 1, high)
}

// Lower Bound
// Definition says that Smaller Index such that arr[index] >= target
fun lowerBound(arr : IntArray, target: Int) : Int {
    var ans = arr.size
    var low = 0
    var high = arr.size-1
    while (low <= high) {
        var mid = low + (high - low)/2
        if (arr[mid] >= target) {
            ans = mid
            high = mid - 1
        }else {
            low = mid + 1
        }
    }
    return ans
}

//Upper Bound
// Definition says that smaller index such that arr[index] > target
fun upperBound(arr : IntArray, target : Int) : Int {
    var ans = arr.size
    var low = 0
    var high = arr.size - 1

    while (low <= high) {
        var mid = low + (high - low)/2
        if (arr[mid] > target) {
            ans = mid
            high = mid - 1
        }else {
            low = mid + 1
        }
    }

    return ans
}


// Smallest number in arr which is >= target
fun ceil(arr : IntArray, target : Int) : Int {
    var ans = -1
    var low = 0
    var high = arr.size-1
    while (low <= high) {
        var mid = low + (high - low)/2
        if (arr[mid] >= target) {
            ans = arr[mid]
            high = mid - 1
        }else {
            low = mid + 1
        }
    }
    return ans
}


// Largest number in arr which is <= target
fun floor(arr : IntArray, target : Int) : Int {
    var ans = -1
    var low = 0
    var high = arr.size - 1
    while (low <= high) {
        var mid = low + (high - low)/2
        if (arr[mid] <= target) {
            ans = arr[mid]
            low = mid + 1
        }else {
            high = mid - 1
        }
    }
    return ans
}

fun ceilAndFloor(arr : IntArray, target: Int) : IntArray {
    var floor = floor(arr, target)
    var ceil = ceil(arr, target)
    return intArrayOf(floor, ceil)
}
