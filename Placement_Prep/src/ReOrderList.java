public class ReOrderList {
    public void reorderList(ListNode_New head) {
        ListNode_New fast = head; ListNode_New slow = head;
        //Middle of List
        while(fast != null && fast.next != null){
            slow = slow.next; fast = fast.next.next;
        }
        //Reverse from middle
        ListNode_New first = head;
        ListNode_New second = rev(slow.next);
        slow.next = null;
        //Merge
        while(second != null){
            ListNode_New t1 = first.next; ListNode_New t2 = second.next;
            first.next = second;
            second.next = t1;
            first = t1; second = t2;
        }
    }

    public ListNode_New rev(ListNode_New head){
        ListNode_New temp = head; ListNode_New prev = null;
        while(temp != null){
            ListNode_New next = temp.next;
            temp.next = prev;
            prev = temp; temp = next;
        }
        return prev;
    }
}
