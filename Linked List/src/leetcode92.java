public class leetcode92 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(left==right)
                return head;
            ListNode present=head;
            ListNode prev=null;
            for(int i=0;present!=null&&i<left-1;i++){
                prev = present;
                present=present.next;
            }
            ListNode last=prev;
            ListNode newEnd=present;
            ListNode after=null;
            for(int i=0;present!=null&&i<right-left+1;i++){
                after = present.next;
                present.next = prev;
                prev = present;
                present = after;
            }
            if(last!=null)
                last.next=prev;
            else
                head=prev;
            newEnd.next=present;
            return head;
        }
    }
}
