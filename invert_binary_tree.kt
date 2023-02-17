/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.

 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    val re = invertTree(root)
    print(re)
}

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    invertTreeRecursion(root)
    return root
}

fun invertTreeRecursion(root: TreeNode) {
    if (root.left != null && root.right != null) {
        var tempNode = root.left;
        root.left = root.right
        root.right = tempNode
        invertTreeRecursion(root.left!!)
        invertTreeRecursion(root.right!!)
    } else if (root.left != null && root.right == null) {
        root.right = root.left
        root.left = null
        invertTreeRecursion(root.right!!)
    } else if (root.left == null && root.right != null) {
        root.left = root.right
        root.right = null
        invertTreeRecursion(root.left!!)
    }
}