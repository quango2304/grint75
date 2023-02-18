//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
// typically using all the original letters exactly once.
fun main() {
    print(isAnagram("anagram", "nagaram"))
    print(isAnagram("rat", "car"))
}

//ccount number of each char in 2 map then compare 2 map
fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    var amap = mutableMapOf<Char, Int>()
    var bmap = mutableMapOf<Char, Int>()
    s.forEachIndexed { index, c ->
        if (amap[c] == null) {
            amap[c] = 0
        }
        amap[c] = amap[c]!! + 1

        var tChar = t[index]
        if (bmap[tChar] == null) {
            bmap[tChar] = 0
        }
        bmap[tChar] = bmap[tChar]!! + 1
    }
    var result = true
    amap.forEach { char, value ->
        if (bmap[char] != value) {
            result = false
        }
    }
    return result
}

//just sort then compare
fun isAnagram2(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    var sorted1 = s.toCharArray()
    sorted1.sort()
    var sorted2 = t.toCharArray()
    sorted2.sort()
    sorted1.forEachIndexed { i, charadter ->
        if (sorted2[i] != charadter) {
            return false
        }
    }
    return true
}