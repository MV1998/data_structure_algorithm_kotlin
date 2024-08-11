package data_structure.linked_list

//single linked list
class MLinkedList(val data : Int) {
    var next : MLinkedList? = null
}

class MDLinkedList(val data: Int) {
    var next : MDLinkedList? = null
    var prev : MDLinkedList? = null
}

