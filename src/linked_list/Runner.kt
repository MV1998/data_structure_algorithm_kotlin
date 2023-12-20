package linked_list

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
    val arr = intArrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13)
    var head : MLinkedList? = arrToLinkedList(arr)
    traversalLinkedList(head)
    println("Length of Linked Link ${lengthOfLinkedList(head)}")
    println("Search result ${searchAnElementInLinkedList(head, 5)}")


    // Lecture - 2 - Deletion in LL
    // Delete head
    // Delete tail
    head = removedHead(head)
    println("after removing head ")
    traversalLinkedList(head)
    println()

    head = removedTail(head)
    println("after removing tail ")
    traversalLinkedList(head)

    head = removeKthNode(head, 2)
    println("deleting with kth node")
    traversalLinkedList(head)
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
    if (newHead == null || newHead.next == null) return null
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