fun climbStairs(n: Int): Int {
//    print("n is $n \n");
    if(n>2) {
        return climbStairs(n-2) + climbStairs(n-1)
    }
    return n
}

fun main() {
    print(climbStairs(45))
}