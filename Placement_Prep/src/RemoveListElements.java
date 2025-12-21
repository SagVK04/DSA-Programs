/*
public class RemoveListElements {
    public ListNode_New removeElements(ListNode_New head, int val) {
        if(head == null) return null;
        if(head.next == null){
            if(head.val == val) return null;
            else
                return head;
        }
        ListNode_New dnode = new ListNode_New(-1);
        ListNode_New temp = dnode; temp.next = head;
        while(temp.next != null){
            if(temp.next.val == val) temp.next = temp.next.next;
            else temp = temp.next;
        }
        return dnode.next;
    }
}
*/