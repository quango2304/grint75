//https://leetcode.com/problems/valid-parentheses/

fun isValid(s: String): Boolean {
    var mutableString = s.toMutableList()
    var i = 0
    while (i <= mutableString.size - 2) {
        if (_isBracketPair(mutableString[i], mutableString[i + 1])) {
            mutableString.removeAt(i)
            mutableString.removeAt(i)
            i = i - 2
        }
        i++
        if (i < 0) i = 0
    }
    if (mutableString.isEmpty()) return true
    return false
}

fun _isBracketPair(a: Char, b: Char): Boolean {
    if ((a.toString() == "(" && b.toString() == ")") || (a.toString() == "{" && b.toString() == "}") || (a.toString() == "[" && b.toString() == "]")) {
        return true
    }
    return false
}