package leetcode_contest

import data_structure.linked_list.MLinkedList
import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
   // println(solve("fafff"))
//    solveSubset(intArrayOf(1,5,11,5), 0, mutableListOf<Int>())
    //print(solveSubsetReturn(intArrayOf(1,2,3), 0, mutableListOf<Int>()))
//    println(squareRoot(10, 3))
//    println(0.01/10.0f)
//    var arrray : Array<String> = Array(100){""}
//    print('c'.code)
//    var charr = charArrayOf('a','c')
//    var arr = IntArray(10)
//    for (index in charr.indices) {
//        arr[index] = charr[index].code
//    }
//    println(nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'd'))
//    var pascalList = mutableListOf<MutableList<Int>>(mutableListOf(1), mutableListOf(1,1))
//    println(generate(5))
    //print(minimumAbsDifference(intArrayOf(40,11,26,27,-20)))
}


fun solve(low : Int, high : Int, arr: IntArray) : Int {
    if (low > high) {
        return -1
    }
    var mid = low + (high - low) / 2
    if (mid == 0 && arr[mid] != arr[mid+1]) {
        return arr[mid]
    }else if (mid == arr.size - 1 && arr[mid] != arr[mid - 1]) {
        return arr[mid]
    }else if (arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) {
        return arr[mid]
    } else {
        var rightSide = solve(mid+1, high, arr)
        if (rightSide != -1) {
            return rightSide
        }
        var leftSide = solve(low, mid-1, arr)
        if (leftSide != -1) {
            return leftSide
        }
    }
    return -1
}
fun singleNonDuplicate(nums: IntArray): Int {
    if (nums.size == 1) {
        return nums[0]
    }
    return solve(0, nums.size-1, nums)
}

fun pivotIndex(nums: IntArray): Int {
    var leftSum = 0
    var rightSum = 0

    if (nums.size == 1) {
        return 0
    }
    for(index in 1..<nums.size) {
        rightSum += nums[index]
    }
    for(index in 1..<nums.size) {
        leftSum += nums[index-1]
        rightSum -= nums[index]
        if (leftSum == rightSum) {
            return index
        }
    }
    return -1
}

fun minimumAbsDifference(arr: IntArray): MutableList<MutableList<Int>>? {
   arr.sort() //O(NlogN)
    var list : MutableList<MutableList<Int>> = mutableListOf()
    var minimumDifference = Int.MAX_VALUE
    for (index in 0..<arr.size-1) {
        var currentMin = abs(abs(arr[index]) - abs(arr[index+1]))
        if (currentMin < minimumDifference) {
            minimumDifference = currentMin
            list.clear()
            list.add(mutableListOf(arr[index], arr[index+1]))
        }else if (currentMin == minimumDifference) {
            list.add(mutableListOf(arr[index], arr[index+1]))
        }
    }
    // O(N)
    return list
}

fun checkIfAllCharactersAreEqual(s : String) : Boolean {
    for (i in s.indices) {
        if ((i+1) < s.length && s[i] != s[i+1]) {
            return false
        }
    }
    return true
}

fun specialSubString(s : String) : Int {
    //generate sub-string
    var map : HashMap<String, Int> = HashMap<String, Int>()
    for (i in s.indices) {
        for (j in i..s.length) {
            var sub = s.substring(i, j)
            if (sub.isNotEmpty()) {
                if (map.containsKey(s.substring(i, j))) {
                    map[sub]?.let { map.put(sub, it+1) }
                }else{
                    map[sub] = 1
                }
            }
        }
    }
    var longestValue = 0
    for ((key, value) in map) {
        println("$key-$value")
        if (value >= 3) {
            if (checkIfAllCharactersAreEqual(key)) {
                if (key.length > longestValue) {
                    longestValue = key.length
                }
            }
        }
    }
    if (longestValue > 0) return longestValue
    return -1
}

fun addTwoNumbers(l1: MLinkedList?, l2: MLinkedList?): MLinkedList? {
    var templ1 = l1
    var templ2 = l2
    var newHead : MLinkedList? = null
    var tempHead : MLinkedList? = null
    var carry = 0
    while(templ1 != null && templ2 != null) {
        var sum = carry + templ1!!.data + templ2!!.data
        if (sum > 9) {
            carry = 1
            sum = 0
        }else {
            carry = 0
        }
        if (newHead == null) {
            newHead = MLinkedList(sum)
            tempHead = newHead
        }else {
            tempHead?.next = MLinkedList(sum)
            tempHead = tempHead?.next
        }
        templ1 = templ2?.next
        templ2 = templ2?.next
    }

    while(templ1 != null) {
        var sum = carry + templ1!!.data
        if (sum > 9) {
            carry = 1
            sum = 0
        }else {
            carry = 0
        }
        if (newHead == null) {
            newHead = MLinkedList(sum)
            tempHead = newHead
        }else {
            tempHead?.next = MLinkedList(sum)
            tempHead = tempHead?.next
        }
        templ1 = templ1?.next
    }

    while(templ2 != null) {
        var sum = carry + templ2.data
        if (sum > 9) {
            carry = 1
            sum = 0
        }else {
            carry = 0
        }
        if (newHead == null) {
            newHead = MLinkedList(sum)
            tempHead = newHead
        }else {
            tempHead?.next = MLinkedList(sum)
            tempHead = tempHead?.next
        }
        templ2 = templ2.next
    }
    return newHead
}

fun solve(s : String) {
    var n = s.length
    var i = 0
    while (i < n) {
        var j = i
        while (j < n && s[i] == s[j]) {
            j++
        }
        print("${s[i]} : ${j-1} | ")
        i = j
    }
}

// generating the subset of a array
fun solveSubset(arr : IntArray, i : Int, ds : MutableList<Int>) {
    if (i >= arr.size) {
        print(ds)
        return
    }

    ds.add(arr[i])
    solveSubset(arr, i + 1, ds)
    ds.removeAt(ds.size-1)
    solveSubset(arr, i + 1, ds)
}

fun solveSubsetReturn(arr : IntArray, i : Int, ds : MutableList<Int>) : MutableList<MutableList<Int>>{
    if (i >= arr.size) {
        var s1 =  mutableListOf<MutableList<Int>>(ds)
      //  print(s1)
        return s1
    }
    var list = mutableListOf<MutableList<Int>>()
    ds.add(arr[i])
    var s1 : MutableList<MutableList<Int>> = solveSubsetReturn(arr, i + 1, ds)
   // print(s1)
    for (i in s1) {
        list.add(i)
    }
    ds.removeAt(ds.size-1)
    var s2 : MutableList<MutableList<Int>> = solveSubsetReturn(arr, i + 1, ds)
    for (i in s2) {
        list.add(i)
    }
    return list
}

// sort the people
fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
    var priorityQueue : PriorityQueue<Int> =
        PriorityQueue(Comparator.reverseOrder())

    for (height in heights) {
        priorityQueue.add(height)
    }
    var list : MutableList<String> = mutableListOf()
    while(!priorityQueue.isEmpty()) {
        var index = heights.indexOf(priorityQueue.poll())
        list.add(names[index])
    }
    return list.toTypedArray()
}

fun squareRoot(n : Int, p : Int) : Float {
    var s = 0
    var e = n
    var ans : Float = 0.0F
    while (s <= e) {
        var mid = (s + e) / 2
        if (mid * mid == n) {
            return mid.toFloat()
        }else if (mid * mid < 10) {
            ans = mid.toFloat()
            s = mid+1
        }else {
            e = mid-1
        }
    }
    var inc : Float = 0.1F
    for (place in 1..p) {
        while (ans*ans <= n) {
            ans += inc
        }
        ans -= inc
        inc /= 10.0F
    }
    return ans
}

fun nextGreatestLetter(letters: CharArray, target: Char): Char {
    var intArray = IntArray(letters.size)
    for (index in letters.indices) {
        intArray[index] = letters[index].code
    }
    var targetCode = target.code
    var s = 0
    var e = intArray.size-1
    while (s <= e) {
        var mid = (s+e)/2
        if (intArray[mid] == targetCode) {
            for (index in mid..<intArray.size-1) {
                if (intArray[index] < intArray[index+1]) {
                    return letters[index + 1]
                }
            }
            return letters[0]
        }else if (intArray[mid] > targetCode) {
              e = mid - 1
        }else {
            s = mid + 1
        }
    }
    for (index in letters.indices) {
        if (letters[index].code > targetCode){
            return letters[index]
        }
    }
    return letters[0]
}

fun generate(numRows: Int): List<List<Int>> {
    var pascalList = mutableListOf<MutableList<Int>>(mutableListOf(1),
        mutableListOf(1,1))

    if (numRows <= 1) {
        pascalList.removeAt(1)
        return pascalList
    }
    if (numRows <= 2) return pascalList

    for (row in 2..<numRows) {
        var previousRow = row - 1
        var rowAt = mutableListOf<Int>()
        for (index in 0..row) {
            if (index - 1 < 0) {
                rowAt.add(1)
                continue
            }
            if (pascalList[previousRow].size <= index) {
                rowAt.add(1)
                continue
            }
            rowAt.add(pascalList[previousRow][index] + pascalList[previousRow][index-1])
        }
        pascalList.add(rowAt)
    }

    return pascalList
}

fun halvesAreAlike(s : String) : Boolean {
    var left = 0
    var right = s.length / 2
    var aVowelLength = 0
    var bVowelLength = 0
    while (right < s.length) {
        if (s[left] == 'a'
            || s[left] == 'e'
            || s[left] == 'i'
            || s[left] == 'o'
            || s[left] == 'u'
            || s[left] == 'A'
            || s[left] == 'E'
            || s[left] == 'I'
            || s[left] == 'O'
            || s[left] == 'U') {
            aVowelLength++
        }
        if (s[right] == 'a'
            || s[right] == 'e'
            || s[right] == 'i'
            || s[right] == 'o'
            || s[right] == 'u'
            || s[right] == 'A'
            || s[right] == 'E'
            || s[right] == 'I'
            || s[right] == 'O'
            || s[right] == 'U') {
            bVowelLength++
        }
        left++
        right++
    }
    return aVowelLength == bVowelLength
}

fun isIsomorphic(s: String, t: String): Boolean {
    var map : MutableMap<Char, Char> = mutableMapOf()
    for (ind in s.indices) {
        var sch = map[s[ind]]
        if (sch == null) {
            map[s[ind]] = t[ind]
        }
    }
    var stringBuilder = StringBuilder()
    for (ind in s.indices) {
        stringBuilder.append(map[s[ind]])
    }

    return stringBuilder.toString() == t
}