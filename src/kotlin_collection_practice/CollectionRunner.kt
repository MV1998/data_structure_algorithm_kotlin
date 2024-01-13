package kotlin_collection_practice

import java.time.Instant
import java.util.*

fun main() {
    var books = arrayOf<Book>(
        Book(name = "Math1", 120.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math2", 320.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math3", 520.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math4", 720.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math5", 220.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math16", 20.3, "Math", 234, Date.from(Instant.now())),
        Book(name = "Math7", 70.3, "Math", 234, Date.from(Instant.now())),
    )

    var groupedByPrice = books.groupBy { book -> book.price }
    groupedByPrice.forEach { (t, u) -> println("$t has ${u.size}") }
    
}
