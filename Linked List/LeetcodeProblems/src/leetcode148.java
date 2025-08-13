public class leetcode148 {
    public ListNode sortList(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return mergeTwoLists(left,right);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode();
        ListNode end = temp;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                end.next=list1;
                list1=list1.next;
                end=end.next;
            }
            else{
                end.next=list2;
                list2=list2.next;
                end=end.next;
            }
        }
        while(list1 != null){
            end.next=list1;
            end=end.next;
            list1 = list1.next;
        }
        while(list2 != null){
            end.next=list2;
            end=end.next;
            list2 = list2.next;
        }
        return temp.next;
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
    public static void main(String[] args) {

    }
}
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}