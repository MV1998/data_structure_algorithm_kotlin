package kotlin_collection_practice

import java.time.Instant
import java.util.*
import kotlin.collections.ArrayDeque

//import kotlin.collections.HashMap
//import kotlin.collections.HashSet
//import kotlin.collections.LinkedHashMap

fun main() {
    // immutable list
    var immutableList = listOf<String>()
    var notNulls = listOfNotNull<String>()
    var emptyList = emptyList<String>()

    // mutable list
    var arrayList = arrayListOf<String>()
    var mutableList = mutableListOf<String>()

    // immutable set
    var immutableSet = setOf<String>()
    var notNullSet = setOfNotNull<String>()
    var emptySet = emptySet<String>()

    // mutable set
    var mutableSet : Set<String> = mutableSetOf<String>() // object of LinkedHashSet()
    var hashSet : HashSet<String> = hashSetOf<String>() // object of HashSet()
    var linkedHashSet : LinkedHashSet<String> = linkedSetOf<String>() // object of LinkedHashSet()
    var sortedSet : SortedSet<String> = sortedSetOf<String>() // TreeSet()
    var navigableSet : NavigableSet<String> = TreeSet<String>() // TreeSet()

    var mapEntry : Map.Entry<String, String>
    var listIterator : ListIterator<String>
    //immutable map
    var immutableMap = mapOf<String, String>()

    //mutable map
    var mutableMap : Map<String, String> = mutableMapOf<String, String>() // object of LinkedHashMap()
    var hashMap : HashMap<String, String> = hashMapOf<String, String>() // object of HashMap()

    var linkedHashMap : LinkedHashMap<String, String> = linkedMapOf<String, String>()  // object of LinkedHashMap()
    var sortedMap : SortedMap<String, String> = sortedMapOf<String, String>() // TreeMap()
    var navigableMap : NavigableMap<String, String> = TreeMap<String, String>() // TreeMap()

    navigableMap.forEach { (t, u ) ->  }

    var stack : kotlin.collections.ArrayDeque<Char> = ArrayDeque<Char>() // Stack
    var queue : Deque<String> = LinkedList() // Queue // Double Ended Queue


    var priorityQueue : Queue<String> = PriorityQueue(Comparator.reverseOrder())


    var books = arrayOf<Book>(
        Book(name = "Math1", 120.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math2", 320.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math3", 520.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math4", 720.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math5", 220.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math16", 20.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math7", 70.3, "Math", 234, Date.from(Instant.now())),
    )

//    var groupedByPrice = books.groupBy { book -> book.price }
//    groupedByPrice.forEach { (t, u) -> println("$t has ${u.size}") }

    var listOfListOfBooks : List<List<Book>> = listOf(listOf(
        Book(name = "Math1", 120.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math2", 320.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math3", 520.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math4", 720.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math5", 220.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math16", 20.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math7", 70.3, "Math", 234, Date.from(Instant.now())),),

        listOf(
            Book(name = "Math1", 120.3, "Math", 234, Date.from(Instant.now())),
            Book(name = "Math2", 320.3, "Math", 234, Date.from(Instant.now())),
            Book(name = "Math3", 520.3, "Math", 234, Date.from(Instant.now())),
            Book(name = "Math4", 720.3, "Math", 234, Date.from(Instant.now())),
            Book(name = "Math5", 220.3, "Math", 234, Date.from(Instant.now())),
            Book(name = "Math16", 20.3, "Math", 234, Date.from(Instant.now())),
            Book(name = "Math7", 70.3, "Math", 234, Date.from(Instant.now())),))

    listOfListOfBooks.flatten().also { it.forEach { println(it) } }
}
