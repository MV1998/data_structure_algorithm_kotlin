import java.util.*

fun main() {
    print(removeOuterParentheses("(()())(())(()(()))"))
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
