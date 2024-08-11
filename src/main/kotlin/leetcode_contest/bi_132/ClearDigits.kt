package leetcode_contest.bi_132

class ClearDigits {
    fun clearDigits(s: String): String {
        var md = StringBuilder(s)
        while(hasDigit(md.toString().toCharArray())) {
            var i = 0
            while(i < md.toString().length) {
                if (md.toString()[i].isDigit()) {
                    val s1 = md.toString().substring(0, i-1)
                    val s2 = md.toString().substring(i+1, md.toString().length)
                    md = StringBuilder()
                    md.append(s1)
                    md.append(s2)
                    break
                }
                i++
            }
        }
        return md.toString()
    }

    fun hasDigit(chArray : CharArray) : Boolean {
        for (ch in chArray) {
            if (ch.isDigit()) {
                return true
            }
        }
        return false
    }
}