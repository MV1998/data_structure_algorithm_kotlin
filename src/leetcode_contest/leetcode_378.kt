package leetcode_contest

fun main() {
    println(specialSubString("fafff"))
    //println("abcaba".substring(5,6))
}

fun checkIfAllCharactersAreEqual(s : String) : Boolean {
    for (i in s.indices) {
        if ((i+1) < s.length && s[i] != s[i+1]) {
            return false
        }
    }
    return true
}

fun specialSubString(s : String) : Int {
    //generate sub-string
    var map : HashMap<String, Int> = HashMap<String, Int>()
    for (i in s.indices) {
        for (j in i..s.length) {
            var sub = s.substring(i, j)
            if (sub.isNotEmpty()) {
                if (map.containsKey(s.substring(i, j))) {
                    map[sub]?.let { map.put(sub, it+1) }
                }else{
                    map[sub] = 1
                }
            }
        }
    }
    var longestValue = 0
    for ((key, value) in map) {
        println("$key-$value")
        if (value >= 3) {
            if (checkIfAllCharactersAreEqual(key)) {
                if (key.length > longestValue) {
                    longestValue = key.length
                }
            }
        }
    }
    if (longestValue > 0) return longestValue
    return -1
}