package linked_list

fun main() {
    var head = addAtHeadDLL(null, 1)
     head = addAtHeadDLL(null, 2)
     head = addAtHeadDLL(null, 3)
     head = addAtHeadDLL(null, 4)

    println(head?.data)
}

fun addAtHeadDLL(head : MDLinkedList?, data : Int) : MDLinkedList?  {
    if (head == null) return MDLinkedList(data)

    var temp = MDLinkedList(data)
    temp.next = head
    head.prev = temp
    return temp
}