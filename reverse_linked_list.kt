fun reverseList(head: ListNode?): ListNode? {
    var next = head
    var previous: ListNode? = null
    while (next != null) {
        var tempNext = next.next
        next.next = previous
        previous = next
        next = tempNext
    }
    return previous
}

fun main() {
    var list1 = initLinkedList(listValue = listOf(1,2,4))
    reverseList(list1)
    print("a")
}