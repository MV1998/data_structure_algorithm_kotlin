package data_structure.linked_list

fun main() {

     var head = arrayToDLL(intArrayOf(101, 102, 103, 104, 105))
     head = addAtHeadDLL(head, 2)

    traversalOfDLL(head)
    println()
    addAtTailOfDLL(head, 10)
    traversalOfDLL(head)
    println()
    addAtTailOfDLL(head, 12)
    traversalOfDLL(head)
    println()
    head = addAtKthLocationOfDLL(head, 1011, 2)
    traversalOfDLL(head)
    println()
    head = addAtKthLocationOfDLL(head, 10111, 1)
    traversalOfDLL(head)
    println()
    head = addAtKthLocationOfDLL(head, 198, 8)
    traversalOfDLL(head)
    println()
    head = addAtKthLocationOfDLL(head, 1998,18)
    traversalOfDLL(head)
    println()
    head = addNodeWhereDataMatches(head, 100001,12)
    traversalOfDLL(head)
    println()

    println("Deleting the head of the linked list.")
    head = deleteHeadOfDLL(head)
    head = deleteHeadOfDLL(head)
    traversalOfDLL(head)
    println()


    println("Deleting the tail of the linked list.")
    head = deleteTailOfDLL(head)
    traversalOfDLL(head)
    println()

    println("Deleting the kth node of the linked list.")
    head = deleteAtKthNode(head, 9)
    traversalOfDLL(head)
    println()
}

fun addAtHeadDLL(head : MDLinkedList?, data : Int) : MDLinkedList {
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

fun arrayToDLL(arr: IntArray) : MDLinkedList? {
    var head = MDLinkedList(arr[0])
    var temp = head
    for (index in 1..<arr.size) {
        var newNode = MDLinkedList(arr[index])
        temp.next = newNode
        newNode.prev = temp
        temp = newNode
    }
    return head
}

fun addAtKthLocationOfDLL(head : MDLinkedList?, data : Int, k : Int) : MDLinkedList {
    if (head == null) return MDLinkedList(data)

    if (k == 1) {
        var temp = MDLinkedList(data)
        temp.next = head
        head.prev = temp
        return temp
    }

    var nk = 1
    var currentNode = head
    while (currentNode != null) {
        if (nk + 1 == k) {
            var newNode = MDLinkedList(data)
            var temp = currentNode.next
            currentNode.next = newNode
            newNode.prev = currentNode
            newNode.next = temp
            if (temp != null) {
                temp.prev = newNode
            }
            break
        }else {
            ++nk
            currentNode = currentNode.next
        }
    }
    return head
}

fun addNodeWhereDataMatches(head : MDLinkedList?, data : Int, dataToBeMatched : Int) : MDLinkedList {
    if (head == null) return MDLinkedList(data)

    if (head.data == dataToBeMatched) {
        var temp = MDLinkedList(data)
        temp.next = head
        head.prev = temp
        return temp
    }
1
    var currentNode : MDLinkedList = head
    while (currentNode.next != null) {
        if (currentNode.next?.data == dataToBeMatched) {
            var newNode = MDLinkedList(data)
            var temp = currentNode.next
            currentNode.next = newNode
            newNode.prev = currentNode
            newNode.next = temp
            if (temp != null) {
                temp.prev = newNode
            }
            break
        }else {
            currentNode = currentNode.next!!
        }
    }
    return head
}

fun traversalOfDLL(head: MDLinkedList?) {
    var temp = head
    while (temp != null) {
        print("${temp.data} ")
        temp = temp.next
    }
}

fun deleteHeadOfDLL(head : MDLinkedList?) : MDLinkedList? {
    if (head == null) return null
    var temp = head
    var newHead = head.next
    temp.next = null
    newHead?.prev = null
    return newHead
}

fun deleteTailOfDLL(head : MDLinkedList?) : MDLinkedList? {
    if (head == null) return null

    var tail : MDLinkedList = head
    while (tail.next != null) {
        tail = tail.next!!
    }
    var newTail = tail.prev
    newTail?.next = null
    tail.prev = null
    return head
}

fun deleteAtKthNode(head : MDLinkedList?, k : Int)  : MDLinkedList? {
    if (head == null) return null

    if (k == 1) {
        var temp = head
        var newHead = head.next
        temp.next = null
        newHead?.prev = null
        return newHead
    }

    var nk = 1
    var currentNode = head
    while (currentNode != null) {
        if (nk + 1 == k) {
            var temp = currentNode.next?.next
            currentNode.next = temp
            temp?.prev = currentNode
            break
        }else {
            ++nk
            currentNode = currentNode.next
        }
    }
    return head
}