public class RemoveListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        if(head.next == null){
            if(head.val == val) return null;
            else
                return head;
        }
        ListNode dnode = new ListNode(-1);
        ListNode temp = dnode; temp.next = head;
        while(temp.next != null){
            if(temp.next.val == val) temp.next = temp.next.next;
            else temp = temp.next;
        }
        return dnode.next;
    }
}
