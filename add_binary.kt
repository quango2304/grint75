fun main() {
    print(addBinary("11", "1"))
}

fun addBinary(a: String, b: String): String {
    var aString = a
    var bString = b
    if (a.length > b.length) {
        bString = b.padStart(a.length, '0')
    } else if (a.length < b.length) {
        aString = a.padStart(b.length, '0')
    }
    var residual = 0
    var sum = ""
    bString.forEachIndexed { index, char ->
        var addREsult = addThreeNum(
            bString[bString.length - 1 - index].toString().toInt(),
            aString[aString.length - 1 - index].toString().toInt(),
            residual
        )
        residual = addREsult.residual
        sum = sum.padStart(sum.length + 1, addREsult.result.toString().first())
    }
    if (residual == 1) {
        sum = sum.padStart(sum.length + 1, residual.toString().first())
    }
    return sum
}

fun addThreeNum(a: Int, b: Int, c: Int): SumResult {
    var sum = a + b + c
    if(sum == 3) {
        return SumResult(1, 1)
    } else if (sum == 2) {
        return SumResult(0, 1)
    } else if (sum == 1) {
        return SumResult(1, 0)
    }
    return SumResult(0, 0)
}

class SumResult(var result: Int, var residual: Int) {

}


//better solution
