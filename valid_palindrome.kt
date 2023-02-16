fun main() {
    print("isPalindrome: ${isPalindrome("A man, a plan, a canal: Panama")}")
}

fun isPalindrome(s: String): Boolean {
    var upperString = convertStringToOnlyAlphaNumeric(s.toUpperCase())
    if(upperString.isEmpty()) {
        return true
    }
    var i = 0
    while(i < upperString.length/2) {
        if(upperString[i] != upperString[upperString.length - i - 1]) {
            return false
        }
        i++
    }
    return true
}

fun convertStringToOnlyAlphaNumeric(text: String): String {
    val re = Regex("[^A-Za-z0-9]")
    return re.replace(text, "")
}