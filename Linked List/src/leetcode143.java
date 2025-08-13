public class leetcode143 {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
        ListNode s=head; ListNode mid=middleNode(head);
        ListNode e = reverse(mid);
        while(s!=null && e!=null){
            ListNode temp=s.next;
            s.next=e;
            s=temp;
            temp=e.next;
            e.next=s;
            e=temp;
        }
        if(s!=null)
            s.next=null;
    }
    public ListNode middleNode(ListNode head) {
        if(head.next==null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode after = null;
        while (temp != null) {
            after = temp.next; //Preserve the rest linked list
            temp.next = prev; //Reverse the link
            prev = temp;//Move prev
            temp = after;//Move temp
        }
        return prev;
    }
}
