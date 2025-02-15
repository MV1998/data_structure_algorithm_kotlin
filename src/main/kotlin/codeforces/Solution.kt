package codeforces


import java.lang.*
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var t = scanner.nextInt()

    while (t > 0) {
        var n = scanner.nextInt()
        val melodies = mutableListOf<Int>()
        while (n > 0) {
            val notesOfMelody = scanner.nextInt()
            melodies.add(notesOfMelody)
            n--
        }
        var isPerfectMelody = true
        var i = 0
        while (i < melodies.size-1) {
            val isPerfectAdjacentMelody = Math.abs(melodies[i] - melodies[i+1])
            if (isPerfectAdjacentMelody != 5 && isPerfectAdjacentMelody != 7) {
                println("No")
                isPerfectMelody = false
                break
            }
            i++
        }
        if (isPerfectMelody) {
            println("Yes")
        }
        t--
    }
}
