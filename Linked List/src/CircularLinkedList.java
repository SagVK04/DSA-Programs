public class CircularLinkedList {
    private int size;
    public CircularLinkedList(){
        size=0;
    }
    private class Node{ //Structure of node is hidden
        private int val;
        private Node next;
        public Node(int value){
            val=value;
        }
        public Node(int val,Node next){
            this.val = val; this.next = next;
        }
    }
    private Node head;
    private Node tail;
    public void insert(int val){
        Node node = new Node(val);
        if(head==null){
            head=node; tail=node; size+=1;
            return;
        }
        tail.next=node;
        node.next=head;
        tail=node;
        size+=1;
    }
    public void display(){
        Node temp = head;
        do {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }while (temp!=head);
        System.out.print(temp.val);
        System.out.println();
        System.out.println("Size of linked list: "+size);
    }
    public int delete(int val){
        int removed=-1;
        if (head==tail){
            if(head.val == val){
                removed = head.val;
                head=null;tail=null;
                size-=1;
                return removed;
            }
            else{
                return removed;
            }
        }
        Node temp=head;
        if(temp.val==val){
            removed = temp.val;
            head=head.next;
            tail.next=head;
            size-=1;
            return removed;
        }
        while (temp.next.val!=val){
            if(temp.next==head)
                return removed;
            temp=temp.next;
        }
        removed=temp.next.val;
        temp.next=temp.next.next;
        size-=1;
        return removed;
    }
}
