public class leetcode142 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        ListNode first = head;
        ListNode second = head;
        int length = cycleLength(head);
        if(length==-1)
            return null;
        while(length>0){
            second = second.next;
            length--;
        }
        while(first != second){
            first=first.next;
            second=second.next;
        }
        return first;
    }
    public int cycleLength(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        int count=0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                do{
                    slow=slow.next;
                    count++;
                }while(slow!=fast);
                return count;
            }
        }
        return -1;
    }
}
