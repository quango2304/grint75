fun majorityElement(nums: IntArray): Int {
    var countMap = mutableMapOf<Int, Int>()
    var max = 0
    var currentResult = nums[0]
    nums.forEach {
        if (countMap[it] == null) {
            countMap[it] = 0
        }
        countMap[it] = countMap[it]!! + 1
        if (countMap[it]!! > max) {
            max = countMap[it]!!
            currentResult = it
        }
    }
    return currentResult
}