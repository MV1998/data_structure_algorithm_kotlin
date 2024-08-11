package data_structure.linked_list

import java.util.*


/*
1351. Count Negative Numbers in a Sorted Matrix
I have solved this question using two naive approaches but i have seen in the solution people have solved using binary search.
when i will learn binary search then i will solve this question again.



 */


fun main() {

    // Tip while solving linked list question
    // start thinking edge case
    // like head is null, head.next is null

    // Lecture - 1 : take u forward
    // Create Linked list
    // Array to linked list
    // traversal
    // search an element
    // find length of linked list
    val arr = intArrayOf(1,0,0,1,0,0,1,1,1,0,0,0,0,0,0)
    var head = arrToLinkedList(arr)
    print(getDecimalValue(head))
//    traversalLinkedList(head)
//    println("Length of Linked Link ${lengthOfLinkedList(head)}")
//    println("Search result ${searchAnElementInLinkedList(head, 5)}")
//
//
//    // Lecture - 2 - Deletion in LL
//    // Delete head
//    // Delete tail
//    head = removedHead(head)
//    println("after removing head ")
//    traversalLinkedList(head)
//    println()
//
//    head = removedTail(head)
//    println("after removing tail ")
//    traversalLinkedList(head)
//
//    head = removeKthNode(head, 2)
//    println("deleting with kth node")
//    traversalLinkedList(head)
//
//
//    var addHead = addAtHead(null, 101)
//    addHead = addAtHead(addHead, 102)
//    addHead = addAtHead(addHead, 103)
//    addHead = addAtHead(addHead, 1024)
//    addHead = addAtHead(addHead, 1025)
//    println("Adding at head")
//    traversalLinkedList(addHead)
//
//    addAtTail(addHead, 1)
//    println("Adding at Tail")
//    traversalLinkedList(addHead)

//    addAtKthNode(head, 6, 1001)
//    println("Adding at kth position")
//    traversalLinkedList(head)
}

fun getDecimalValue(head: MLinkedList?): Int {
    if (head == null) return 0
    if (head.next == null) return head.data

    var builder : StringBuilder = StringBuilder()
    var temp = head
    while(temp != null) {
        builder.append(temp.data)
        temp = temp?.next
    }

    var binaryString : String = builder.toString()
    var decimalNumber : Int = 0
    var raise = 0
    var length = binaryString.length-1
    while(length >= 0) {
        decimalNumber += (Math.pow(2.0, raise.toDouble()).toInt() * binaryString[length].digitToInt())
        ++raise
        --length
    }
    return decimalNumber
}

// Time complexity - o(n)
fun arrToLinkedList(arr : IntArray) : MLinkedList {
    var head = MLinkedList(arr[0])
    var temp = head
    for (index in 1..<arr.size) {
        val newNode = MLinkedList(arr[index])
        temp.next = newNode
        temp = newNode
    }
    return head
}

// Time complexity - o(n)
fun traversalLinkedList(head : MLinkedList?) {
    var temp : MLinkedList? = head
    while (temp != null) {
        print("${temp.data} ")
        temp = temp.next
    }
}

// Time complexity - o(n)
fun lengthOfLinkedList(head : MLinkedList?) : Int {
    var count = 0
    var temp : MLinkedList? = head
    while (temp != null) {
        temp = temp.next
        count++
    }
    return count
}

// Time complexity - o(n), o(1), o(n/2)
fun searchAnElementInLinkedList(head : MLinkedList?, search : Int) : Boolean {
    var temp : MLinkedList? = head
    while (temp != null) {
        if (temp.data == search) {
            return true
        }
        temp = temp.next
    }
    return false
}

fun removedHead(head : MLinkedList?) : MLinkedList? {
    var newHead = head
    if (head == null) return null
    var temp = newHead
    newHead = newHead?.next
    return newHead
}

fun removedTail(head : MLinkedList?) : MLinkedList? {
    var newHead = head
    if (newHead?.next == null) return null
    var temp = newHead
    while (temp?.next?.next != null) {
        temp = temp.next
    }
    temp?.next = null
    return newHead
}

fun removeKthNode(head : MLinkedList?, k : Int) : MLinkedList? {
    var newHead = head
    if (newHead == null) return null
    if (k == 1) {
        var temp = newHead
        newHead = newHead.next
        return newHead
    }

    var nk = 1
    var temp = newHead
    while (temp?.next != null) {
        if (nk + 1 == k) {
            temp.next = temp.next?.next
            break
        }else {
            temp = temp.next
            ++nk
        }
    }

    return newHead
}

fun addAtHead(head : MLinkedList?, nodeVal : Int) : MLinkedList {
    if (head == null) return MLinkedList(nodeVal)

    var temp = MLinkedList(nodeVal)
    temp.next = head
    return temp
}

fun addAtTail(head : MLinkedList?, nodeVal : Int) : MLinkedList {
    if (head == null) return MLinkedList(nodeVal)
    var temp : MLinkedList = head
    while (temp.next != null) {
        temp = temp.next!!
    }
    temp.next = MLinkedList(nodeVal)
    return temp
}

fun addAtKthNode(head : MLinkedList?, k : Int, nodeVal: Int) : MLinkedList {
    if (head == null) return MLinkedList(nodeVal)
    if (k == 1) {
        val temp = MLinkedList(nodeVal)
        temp.next = head
        return temp
    }

    var nk = 1
    var temp : MLinkedList? = head
    while (temp != null) {
        if (nk + 1 == k) {
            val newNode = MLinkedList(nodeVal)
            newNode.next = temp.next
            temp.next = newNode
            break
        }else {
            temp = temp.next
            ++nk
        }
    }
    return head
}


// This is not optimial solution
fun removeNthFromEnd(head: MLinkedList?, n: Int): MLinkedList? {
    if (head == null) return null
    if (head.next == null && n == 1) return null

    var stack1 : Stack<Int> = Stack<Int>()
    var temp = head
    while(temp != null) {
        stack1.push(temp.data)
        temp = temp.next
    }

    var index = 1
    var answer : Stack<Int> = Stack()
    while(!stack1.empty()) {
        if (index != n) {
            answer.push(stack1.pop())
        }else {
            stack1.pop()
        }
        ++index
    }

    var newHead = MLinkedList(answer.pop())
    var tempHead = newHead
    while(!answer.empty()) {
        var newNode = MLinkedList(answer.pop())
        tempHead.next = newNode
        tempHead = newNode
    }
    return newHead

}

//fun postorderTraversal(root: MLinkedList?): List<Int> {
//    if (root == null) return ArrayList()
//
//    var fromRight : List<Int> = postorderTraversal(root?.right)
//    var fromLeft : List<Int> = postorderTraversal(root?.left)
//    var makelist : MutableList<Int> = ArrayList()
//    makelist.add()
//    makelist.addAll(fromLeft)
//    return makelist
//}

fun partition(head: MLinkedList?, x: Int): MLinkedList? {
    var lesserThanXList = mutableListOf<Int>()
    var greaterThanXList = mutableListOf<Int>()
    var temp = head
    while (temp != null) {
        if (temp.data < x) {
            lesserThanXList.add(temp.data)
        }else {
            greaterThanXList.add(temp.data)
        }
        temp = temp.next
    }
    var head1 : MLinkedList? = null
    var temp1 = head1
    var head2 : MLinkedList? = null
    var temp2 = head2
    for (ele in lesserThanXList) {
        if (head1 == null) {
            var newNode = MLinkedList(ele)
            head1 = newNode
            temp1 = head1
        }else {
            var newNode = MLinkedList(ele)
            temp1?.next = newNode
            temp1 = temp1?.next
        }
    }
    for (ele in greaterThanXList) {
        if (head2 == null) {
            var newNode = MLinkedList(ele)
            head2 = newNode
            temp2 = head2
        }else {
            var newNode = MLinkedList(ele)
            temp2?.next = newNode
            temp2 = temp2?.next
        }
    }
    temp1?.next= head2
    return head1
}

