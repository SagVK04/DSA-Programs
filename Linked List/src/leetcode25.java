public class leetcode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1 || head==null)
            return head;
        if(head.next==null)
            return head;
        ListNode temp=head; ListNode prev=null;
        int count=0;
        while(temp!=null){
            ListNode knode=findKnode(temp,k);
            if(knode==null){
                if(prev!=null)
                    prev.next=temp;
                break;
            }
            ListNode nextNode = knode.next;
            knode.next=null;
            reverse(temp);
            if(temp==head)
                head=knode;
            else
                prev.next=knode;
            prev = temp;
            temp=nextNode;
        }
        return head;
    }
    public ListNode findKnode(ListNode head,int k){
        ListNode temp=head; int count=0;
        while(temp!=null && count!=k-1){
            temp=temp.next; count++;
        }
        return temp;
    }
    public void reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode after = null;
        while (temp != null) {
            after = temp.next; //Preserve the rest linked list
            temp.next = prev; //Reverse the link
            prev = temp;//Move prev
            temp = after;//Move temp
        }
    }
}
