public class leetcode206 {
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode after = null;
        while (temp != null) {
            after = temp.next;
            temp.next = prev;
            prev = temp;
            temp = after;
        }
        return prev;
    }
}
