fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    while(slow!= null && fast?.next != null) {
        fast = fast.next!!.next
        slow = slow!!.next
        if(fast == slow) {
            return true
        }
    }
    return false
}