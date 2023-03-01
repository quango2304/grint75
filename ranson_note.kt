fun canConstruct(ransomNote: String, magazine: String): Boolean {
    var characterCounter = mutableMapOf<Char, Int>()
    magazine.forEach {
        it
        if (characterCounter[it] == null) {
            characterCounter[it] = 0
        }
        characterCounter[it] = characterCounter[it]!! + 1
    }
    ransomNote.forEach {
        if (characterCounter[it] == null || characterCounter[it] == 0) {
            return false
        }
        characterCounter[it] = characterCounter[it]!! - 1
    }
    return true
}