//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//https://www.youtube.com/watch?v=1pkOgXD63yU
fun main() {

}

fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var left = 0
    var right = 0
    while (right < prices.size) {
        if (prices[left] < prices[right]) {
            maxProfit = Math.max(maxProfit, prices[right] - prices[left])
        } else {
            //if found the new smaller number ,assign it to left
            left = right
        }
        right++
    }
    //note that the algo will return max profit, not the left and right, so maybe left and right not correct but max profit will still correct
    return maxProfit
}

fun maxProfit1(prices: IntArray): Int {
    var maxProfit = 0
    var i = 0
    while (i < prices.size - 1) {
        var j = i + 1
        while (j < prices.size) {
            val profit = prices[j] - prices[i]
            if (profit > maxProfit) {
                maxProfit = prices[j] - prices[i]
            }
            j++
        }
        i++
    }
    return maxProfit
}