package leetcode_contest

import linked_list.MDLinkedList
import linked_list.MLinkedList
import java.util.PriorityQueue

fun main() {
   // println(solve("fafff"))
//    solveSubset(intArrayOf(1,5,11,5), 0, mutableListOf<Int>())
    //print(solveSubsetReturn(intArrayOf(1,2,3), 0, mutableListOf<Int>()))
    println(squareRoot(10, 3))
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

fun squareRoot(n : Int, p : Int) : Int {
    var s = 0
    var e = n
    var ans = 0
    while (s <= e) {
        println("running")
        var mid = (s + e) / 2
        if (mid * mid < 10) {
            ans = mid
            s = mid+1
        }else {
            e = mid-1
        }
    }
    return ans
}