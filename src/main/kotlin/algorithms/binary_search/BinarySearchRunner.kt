package algorithms.binary_search

/*
Kotlin | Java | Retrofit | OkHttp | Coroutines | Picasso | Glide | HILT | Room SQLite | MVVM Pattern | Google API Integration |Third Party Library/API Integration | Design Patterns | UI Customization | MDC (Material Design Component) | Constraint Layout | Motion Layout | Android Jetpack Components | Firebase | Koin | Ktor


 - Actively contribute as a vital member of an agile team, developing and enhancing CGI's TRADE360 SaaS product as a full stack developer.
- Write, debug, and optimize code to ensure efficient functionality and performance of the software.
- Develop intuitive and visually appealing UI components to enhance user experience and satisfaction.
- Conduct thorough code reviews to ensure adherence to best practices and maintain high code quality standards.
- Utilize a diverse range of technologies, including Java, Spring Boot, MySQL, AngularJS, Git, VSCode, Confluence, and JIRA, to accomplish project goals efficiently and effectively.



- Backend Developer in an Agile team for over 1.5 years, focusing on critical backlog JIRAs, defect resolution, and some CRs.
- Utilized Java, Spring Boot, MySQL, Intellij, and Gitlab for development.
- Collaborated effectively with team members to deliver high-quality solutions.
- Assisted in prioritizing and resolving critical issues to ensure smooth project progression.
- Developed and maintained robust codebase, ensuring optimal performance and scalability.
- Actively contributed to code reviews, providing insightful feedback to enhance code quality.
- Successfully integrated new features and functionalities, enhancing the overall user experience.
- Demonstrated strong problem-solving skills, addressing technical challenges promptly and efficiently.
- Implemented unit tests and performed thorough debugging to ensure bug-free code deployment.
- Maintained clear documentation of codebase and system architecture for future reference.
- Actively participated in daily stand-up meetings, sprint planning, and retrospective sessions.


 */

fun main() {
//    println(binarySearch(intArrayOf(1,2,3,4,5,6,7,8,9,10), 6))
//    println(recursiveBinarySearch(intArrayOf(1,2,3,4,5,6,7,8,9,10), 6, 0, 9))
//    println(lowerBound(intArrayOf(1,2,3,3,5,8,8,10,10,11), 8))
//    println(upperBound(intArrayOf(1,2,3,3,5,8,8,10,10,11), 8))

//    var floorAndCeil = ceilAndFloor(intArrayOf(3,4,4,7,8,10), 8)
//    println(floorAndCeil[0])
//    println(floorAndCeil[1])

    print(searchSortedArray(intArrayOf(4,5,6,7,0,1,2), 0))
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

// Upper Bound
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


fun searchSortedArray(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1
    while (low <= high) {
        var mid = (low + high)/2
        if (nums[mid] == target) {
            return mid
        }else if (nums[low] <= nums[mid] &&
            nums[low] <= target && target <= nums[mid]) {
            high = mid - 1
        }else {
            low = mid + 1
        }
    }
    return -1
}

fun minimumInRotatedSortedArray(nums : IntArray) : Int {
    var low = 0
    var high = nums.size - 1
    var minimum = Int.MAX_VALUE
    while (low <= high) {
        var mid = low + (high - low) / 2
        if (nums[low] <= nums[mid]) {
            minimum = Math.min(minimum, nums[low])
            low = mid + 1
        }else{
            minimum = Math.min(minimum, nums[mid])
            high = mid - 1
        }
    }
    return minimum
}