//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

fun main() {
    val root = TreeNode(6)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(0)
    root.left?.right = TreeNode(4)
    root.left?.right?.left = TreeNode(3)
    root.left?.right?.right = TreeNode(5)
    root.right = TreeNode(8)
    root.right?.left = TreeNode(7)
    root.right?.right = TreeNode(9)
    var result = lowestCommonAncestor(root, TreeNode(2), TreeNode(8))
    print("result ${result?.`val`}")
}

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    var nodePathToP = mutableListOf<TreeNode>()
    var nodePathToQ = mutableListOf<TreeNode>()
    binarySearch(root, p?.`val`, nodePathToP)
    binarySearch(root, q?.`val`, nodePathToQ)
    nodePathToP.forEachIndexed { index, treeNode ->
        if ((index == nodePathToP.size - 1 || index == nodePathToQ.size - 1) && nodePathToQ[index].`val` == nodePathToP[index].`val`) {
            return nodePathToP[index]
        }
        if (nodePathToP[index].`val` != nodePathToQ[index].`val`) {
            return nodePathToP[index - 1]
        }
    }
    return null
}


fun binarySearch(root: TreeNode?, elementToFind: Int?, nodeArray: MutableList<TreeNode>) {
    if (root == null || elementToFind == null) return
    nodeArray.add(root)
    if (root.`val` == elementToFind) {
        return
    } else if (elementToFind > root.`val` && root.right != null) {
        binarySearch(root.right!!, elementToFind, nodeArray)
    } else if (elementToFind < root.`val` && root.left != null) {
        binarySearch(root.left!!, elementToFind, nodeArray)
    }
}