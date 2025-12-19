public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy1 = new ListNode(-1,null);
        ListNode dummy2 = new ListNode(-1,null);
        ListNode t1 = head; ListNode t2 = head.next;
        dummy1.next = t1; dummy2.next = t2;
        while(t2 != null && t2.next!= null){
            ListNode next_1 = t1.next.next; ListNode next_2 = t2.next.next;
            t1.next = t1.next.next; t2.next = t2.next.next;
            t1 = next_1; t2 = next_2;
        }
        t1.next = dummy2.next;
        return dummy1.next;
    }
}
