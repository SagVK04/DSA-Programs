public class leetcode141 {
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
                return true;
        }
        return false;
    }
    public static int length(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int count=0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                ListNode temp = slow;
                do{
                    count++; temp=temp.next;
                }while (temp!=fast);
            }
        }
        return count;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}