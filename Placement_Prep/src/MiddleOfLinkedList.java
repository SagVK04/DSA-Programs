public class MiddleOfLinkedList {
    public ListNode_New middleNode(ListNode_New head) {
        ListNode_New slow = head;
        ListNode_New fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next; fast=fast.next.next;
        }
        return slow;
    }
}
