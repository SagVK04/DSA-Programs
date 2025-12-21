/*
public class MergeSortedList {
    public ListNode_New mergeTwoLists(ListNode_New list1, ListNode_New list2) {
        ListNode_New dnode = new ListNode_New(-1);
        ListNode_New temp = dnode;
        ListNode_New t1 = list1; ListNode_New t2 = list2;
        while(t1 != null && t2 != null){
            if(t1.val < t2.val){
                temp.next = t1;
                temp = temp.next;
                t1 = t1.next;
            }
            else{
                temp.next = t2;
                temp = temp.next;
                t2 = t2.next;
            }
        }
        if(t1 == null)
            temp.next = t2;
        else
            temp.next = t1;
        return dnode.next;
    }
}
*/