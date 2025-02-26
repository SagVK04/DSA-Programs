public class leetcode148 {
    public leetcode21.ListNode mergeTwoLists(leetcode21.ListNode list1, leetcode21.ListNode list2) {
        ListNode temp = new ListNode();
        leetcode21.ListNode end = temp;
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
    public class ListNode {
      int val;
      leetcode21.ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}

