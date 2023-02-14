//https://leetcode.com/problems/merge-two-sorted-lists/

fun main() {
    var list1 = initLinkedList(listValue = listOf(1,2,4))
    var list2 = initLinkedList(listValue = listOf(1,3,4))
    var result = mergeTwoLists(list1, list2)
    print("resultresult $result")
}

fun initLinkedList(listValue: List<Int>): ListNode {
    var head: ListNode? = null
    var next: ListNode? = null
    for(value in listValue) {
        if(head == null) {
            head = ListNode(value)
            next = head
        } else {
            next!!.next = ListNode(value)
            next = next.next
        }
    }
    return head!!
}


fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    return merge(list1, list2, null, null)
}

fun merge(list1: ListNode?, list2: ListNode?, result: ListNode?, head: ListNode?): ListNode? {
    var firstValue = list1?.`val`
    var secondValue = list2?.`val`
    if(firstValue == null && secondValue == null) {
        return head
    }
    if(firstValue != null && secondValue == null) {
        if(head == null) {
            val head = addValue(result, firstValue)
            return merge(list1?.next, list2, head, head)
        } else {
            return merge(list1?.next, list2, addValue(result, firstValue), head)
        }
    }
    if(firstValue == null && secondValue != null) {
        if(head == null) {
            val head = addValue(result, secondValue)
            return merge(list1, list2?.next, head, head)
        } else {
            return merge(list1, list2?.next, addValue(result, secondValue), head)
        }
    }
    if(firstValue!!<secondValue!!) {
        return if(head == null) {
            val head = addValue(result, firstValue)
            merge(list1?.next, list2, head, head)
        } else {
            merge(list1?.next, list2, addValue(result, firstValue), head)
        }
    } else {
        return if(head == null) {
            val head = addValue(result, secondValue)
            merge(list1, list2?.next, head, head)
        } else {
            merge(list1, list2?.next, addValue(result, secondValue), head)
        }
    }
}

fun addValue(result: ListNode?, value: Int): ListNode {
    if(result == null) {
        return ListNode(value)
    }
    var neextNode = ListNode(value)
    result.next = neextNode
    return neextNode
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

//better solution
fun mergeTwoListsBetter(l1: ListNode?, l2: ListNode?): ListNode? {
    var l1 = l1
    var l2 = l2
    val prehead = ListNode(-1)
    var cur: ListNode? = prehead
    while (l1 != null && l2 != null) {
        if (l1.`val` <= l2.`val`) {
            cur!!.next = l1
            l1 = l1.next
        } else {
            cur!!.next = l2
            l2 = l2.next
        }
        cur = cur.next
    }
    cur!!.next = l1 ?: l2
    return prehead.next
}