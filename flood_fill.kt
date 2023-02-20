//https://leetcode.com/problems/flood-fill/

fun main() {
//    var image = arrayOf(intArrayOf(1,1,1),intArrayOf(1,1,0),intArrayOf(1,0,1))
    var image = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))

    print(floodFill(image, 0, 0, 0))
}

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    floodFillRecur(image[sr][sc], color, image, sr, sc)
    image.forEach {
        it.forEach {
            print("value: $it \n")
        }
    }
    return image
}

fun floodFillRecur(initialValue: Int, color: Int, image: Array<IntArray>, sr: Int, sc: Int) {
    var width = image.size
    var height = 0
    if (image.isNotEmpty()) {
        height = image[0].size
    }
    if (sr < 0 || sr > width - 1 || sc < 0 || sc > height - 1) {
        return
    } else if (image[sr][sc] == initialValue && image[sr][sc] != color) {//make sure not fill again a point that has filled before
        image[sr][sc] = color
        floodFillRecur(initialValue, color, image, sr - 1, sc)
        floodFillRecur(initialValue, color, image, sr + 1, sc)
        floodFillRecur(initialValue, color, image, sr, sc + 1)
        floodFillRecur(initialValue, color, image, sr, sc - 1)
    }
}

class NotedPoint(var i: Int, var j: Int) {

}


