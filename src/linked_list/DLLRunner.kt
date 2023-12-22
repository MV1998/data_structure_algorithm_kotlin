package linked_list

fun main() {
    var head = addAtHeadDLL(null, 1)
     head = addAtHeadDLL(head, 2)
     head = addAtHeadDLL(head, 3)
     head = addAtHeadDLL(head, 4)

    traversalOfDLL(head)
    println()
    addAtTailOfDLL(head, 10)
    traversalOfDLL(head)
    println()
    addAtTailOfDLL(head, 12)
    traversalOfDLL(head)
    println()
}

fun addAtHeadDLL(head : MDLinkedList?, data : Int) : MDLinkedList  {
    if (head == null) return MDLinkedList(data)

    var temp = MDLinkedList(data)
    temp.next = head
    head.prev = temp
    return temp
}

fun addAtTailOfDLL(head : MDLinkedList?, data : Int) : MDLinkedList {
    if (head == null) return MDLinkedList(data)

    var temp = head
    while (temp?.next != null) {
        temp = temp.next
    }
    var newNode = MDLinkedList(data)
    temp?.next = newNode
    newNode.prev = temp

    return head
}

fun traversalOfDLL(head: MDLinkedList?) {
    var temp = head
    while (temp != null) {
        print("${temp.data} ")
        temp = temp.next
    }
}