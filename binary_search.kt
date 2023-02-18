fun main(){
    print(search(arrayOf(1,2,3,4,5,6).toIntArray(), 4))
}

fun search(nums: IntArray, target: Int): Int {
    return binarySearch(nums, target, 0, nums.size -1)
}

fun binarySearch(nums: IntArray, target: Int, left: Int, right: Int): Int {
    //0 1 2 3 4 5 6
    //left = 3, right = 6 => mid = 4
//    print("left $left, right: $right \n")
    if(left == right) {
        if(nums[left] == target) {
            return left
        } else {
            return -1
        }
    }
    if(right < left) {
        return -1
    }
    var middle = ((right - left) / 2) + left
//    print("left: $left, right: $right, middle: $middle \n")
    if (nums[middle] == target) {
        return middle
    } else if (nums[middle] > target) {
        return binarySearch(nums, target, left, middle - 1)
    } else {
        return binarySearch(nums, target, middle + 1, right)
    }
}