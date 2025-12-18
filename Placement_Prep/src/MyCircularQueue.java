public class MyCircularQueue {
    int space; ListNode_New left; ListNode_New right;
    public MyCircularQueue(int k) {
        space = k;
        left = new ListNode_New(-1,null,null);
        right = new ListNode_New(-1,left,null);
        left.next = right;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        ListNode_New cur = new ListNode_New(value,right.prev,right);
        right.prev.next = cur;
        right.prev = cur;
        space -= 1;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        left.next = left.next.next;
        left.next.prev = left;
        space += 1;
        return true;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return left.next.val;
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return right.prev.val;
    }

    public boolean isEmpty() {
        return left.next == right;
    }

    public boolean isFull() {
        return space == 0;
    }
}
class ListNode_New {
    int val; ListNode_New prev; ListNode_New next;
    public ListNode_New(int val, ListNode_New prev, ListNode_New next){
        this.val = val; this.prev = prev; this.next = next;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */