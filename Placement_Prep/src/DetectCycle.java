public class DetectCycle {
    public boolean hasCycle(ListNode_New head) {
        ListNode_New fast = head;
        ListNode_New slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
                return true;
        }
        return false;
    }
    public ListNode_New detectCycle(ListNode_New head) {
        ListNode_New fast = head;
        ListNode_New slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
