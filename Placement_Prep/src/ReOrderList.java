public class ReOrderList {
    public void reorderList(ListNode head) {
        ListNode fast = head; ListNode slow = head;
        //Middle of List
        while(fast != null && fast.next != null){
            slow = slow.next; fast = fast.next.next;
        }
        //Reverse from middle
        ListNode first = head;
        ListNode second = rev(slow.next);
        slow.next = null;
        //Merge
        while(second != null){
            ListNode t1 = first.next; ListNode t2 = second.next;
            first.next = second;
            second.next = t1;
            first = t1; second = t2;
        }
    }

    public ListNode rev(ListNode head){
        ListNode temp = head; ListNode prev = null;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp; temp = next;
        }
        return prev;
    }
}
