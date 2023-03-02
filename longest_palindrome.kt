//https://leetcode.com/problems/longest-palindrome/


fun main() {
    var strsing = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"
    print(strsing.toCharArray().sorted().joinToString("") + "\n")
//    return
    print(
        longestPalindrome(
            strsing
        )
    )
}

//each even character will add to sum
//each odd character will minus by one
fun longestPalindrome(s: String): Int {
    var counterMap = mutableMapOf<Char, Int>()
    s.forEach {
        if (counterMap[it] == null) {
            counterMap[it] = 0
        }
        counterMap[it] = counterMap[it]!! + 1
    }
    var result = 0
    var hasOdd = false
    counterMap.forEach { (key, value) ->
        if (value % 2 == 0) {
            result += value
        } else {
            hasOdd = true
            result += value -1
        }
    }
    if(hasOdd) {
        result++
    }
    return result
}

