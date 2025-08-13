public class leetcode234 {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode mid = middleNode(head);
            ListNode secondHead = reverse(mid);
            ListNode rrhead = secondHead;
            while(head!=secondHead && secondHead!=null){
                if(head.val!=secondHead.val)
                    break;
                head=head.next;
                secondHead=secondHead.next;
            }
            if(head==secondHead || secondHead==null)
                return true;
            return false;
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
}
