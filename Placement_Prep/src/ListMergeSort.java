public class ListMergeSort {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = findMid(head); //Find Left Middle
        ListNode right = mid.next;
        mid.next = null; //Seperates single list into two from middle
        ListNode left_new = sortList(head); //Divide into smaller lists
        ListNode right_new = sortList(right); //Divide into smaller lists
        return sort(left_new,right_new); //Merge two lists
    }
    public ListNode sort(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1,null);
        ListNode temp = dummy;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                temp.next = head1;
                temp = head1; head1 = head1.next;
            }
            else{
                temp.next = head2;
                temp = head2; head2 = head2.next;
            }
        }
        if(head1 == null)
            temp.next = head2;
        else
            temp.next = head1;
        return dummy.next;
    }
    public ListNode findMid(ListNode head){
        ListNode slow = head; ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next; fast = fast.next.next;
        }
        return slow;
    }
}
