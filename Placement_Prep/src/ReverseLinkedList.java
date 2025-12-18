public class ReverseLinkedList {
    public ListNode_New reverseList(ListNode_New head) {
        if(head == null || head.next == null)
            return head;
        ListNode_New newHead = reverseList(head.next);
        ListNode_New front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode_New reverseList1(ListNode_New head) {
        ListNode_New prev = null; ListNode_New temp = head;
        while(temp != null){
            ListNode_New next = temp.next;
            temp.next = prev;
            prev = temp; temp = next;
        }
        return prev;
    }
}
