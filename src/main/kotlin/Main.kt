import java.util.*

fun main() {
//    print(removeOuterParentheses("(()())(())(()(()))"))

    // commit1 comment
    // commit2 comment
    println(countCharacters("test input"))
}



fun countCharacters(str : String) : Map<Char, Int> {
    val charactersCount = mutableMapOf<Char, Int>()

    //getOrDefault, getOrNull, getOrPut
    for (ch in str) {
        val isPresent = charactersCount.getOrElse(ch) {null}
        if (isPresent != null) {
            charactersCount[ch] = charactersCount[ch]!! + 1
        }else {
            charactersCount[ch] = 1
        }
    }

    return charactersCount
}


fun removeOuterParentheses(s: String): String {
    var stack : Stack<Char> = Stack()
    var string : StringBuilder = StringBuilder()
    for (ch in s) {
        if (stack.isEmpty()) {
            stack.push(ch)
            continue
        }
        if (ch == '(' && stack.peek() == ')') {
            stack.pop()
            if (!stack.isEmpty()) {
                string.append(ch)
            }
            continue
        }
        if (ch == ')' && stack.peek() == '(') {
            stack.pop()
            if (!stack.isEmpty()) {
                string.append(ch)
            }
            continue
        }
        stack.push(ch)
        if (!stack.isEmpty()) {
            string.append(ch)
        }
    }
    return string.toString()
}
