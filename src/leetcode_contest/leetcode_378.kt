package leetcode_contest

import linked_list.MDLinkedList
import linked_list.MLinkedList

fun main() {
    println(specialSubString("fafff"))
    //println("abcaba".substring(5,6))
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