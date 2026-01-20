public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        ListNode newHead = reverse(mid);
        while(newHead != null){ //Second  half always be greater, head will never reach second  half
            if(head.val != newHead.val) return false;
            head = head.next; newHead = newHead.next;
        }
        return true;
    }
    public ListNode findMid(ListNode head){
        ListNode slow=head; ListNode fast=head;
        while(fast != null && fast.next != null){
            slow = slow.next; fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
