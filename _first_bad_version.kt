fun main() {
    var a = Solution()
    print("a.firstBadVersion(3) ${a.firstBadVersion(2126753390)}")
}

class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var lastBad = 1
        var start = 1
        var end = n
        while(start<= end) {
            var mid = start + (end - start) /2 // using start + end /2 may cause overflow int
            if(isBadVersion(mid)) {
                end = mid -1
                lastBad = mid
            } else {
                start = mid + 1
            }
        }
        return lastBad
    }
}
//123-4-5

abstract class VersionControl {
    var bad = 1702766719
    abstract fun firstBadVersion(n: Int): Int
    fun isBadVersion(version: Int): Boolean {
        return version >= bad
    }
}