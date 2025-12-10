public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null; ListNode temp = head;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp; temp = next;
        }
        return prev;
    }
}
