package linked_list

fun main() {
    // Lecture - 1 : take u forward
    // Create Linked list
    // Array to linked list
    // traversal
    // search an element
    // find length of linked list
    val arr = intArrayOf(1,2,3,4,5,6)
    val head = arrToLinkedList(arr)
    traversalLinkedList(head)
    println("Length of Linked Link ${lengthOfLinkedList(head)}")
    println("Search result ${searchAnElementInLinkedList(head, 5)}")


    // Lecture - 2 - In progress

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
fun traversalLinkedList(head : MLinkedList) {
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