//https://leetcode.com/problems/balanced-binary-tree/submissions/902587966/

fun main() {
//    val root = TreeNode(3)
//    root.left = TreeNode(9)
//    root.right = TreeNode(20)
//    root.right?.left = TreeNode(15)
//    root.right?.right = TreeNode(7)
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
        root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(3)
    root.left?.left?.left = TreeNode(4)
    root.left?.left?.right = TreeNode(4)
    var result = isBalanced(root)
    print("result ${result}")
}

//at each node, compare the left height and the right height, also return the max(left, right) so the parent node can compare
fun isBalanced(root: TreeNode?): Boolean {
    var resul = checkIsBalanced(root)
    return resul.isBalanced
}

fun checkIsBalanced(root: TreeNode?) : IsBalancedAndHeight {
    if(root == null) {
        return IsBalancedAndHeight(true, 0)
    }
    var leftRrsult = checkIsBalanced(root.left)
    var rightRrsult = checkIsBalanced(root.right)
    if(leftRrsult.isBalanced && rightRrsult.isBalanced && abs(leftRrsult.height - rightRrsult.height) <= 1) {
        return IsBalancedAndHeight(true, getMax(leftRrsult.height, rightRrsult.height) + 1)
    }
    return IsBalancedAndHeight(false, 1)
}

fun abs(value: Int): Int {
    if(value<0) return -value
    return value
}

fun getMax(a: Int, b: Int): Int {
    if (a>b) return a
    return b
}

class IsBalancedAndHeight(var isBalanced: Boolean, var height: Int) {

}