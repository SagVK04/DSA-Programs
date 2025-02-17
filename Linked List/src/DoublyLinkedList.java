public class DoublyLinkedList {
    private int size;
    public DoublyLinkedList(){
        size=0;
    }
    private class Node{ //Structure of node is hidden
        private int val;
        private Node next;
        private Node prev;
        public Node(int value){
            val=value;
        }
        public Node(int val,Node next,Node prev){
            this.val = val; this.next = next; this.prev=prev;
        }
    }
    private Node head;
    private Node tail;
    public void display(){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
        System.out.println("Size of linked list: "+size);
    }
    public void reverseLinkedList(){
        Node temp = head;
        Node last = null;
        while (temp!=null) {
            last=temp;
            temp = temp.next;
        }
        System.out.print("Reverse is: ");
        while (last!=null) {
            System.out.print(last.val + "->");
            last = last.prev;
        }
        System.out.print("null");
        System.out.println();
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next=head;
        node.prev=null;
        if(head!=null)
            head.prev=node;//Throws NPE is there is no item and head==null
        head=node;
        if (tail==null)
            tail=head;
        size+=1;
    }
    public void insertLast(int val){
        Node node = new Node(val);
        if(tail!=null) {
            node.next = tail.next;
            tail.next=node;
            node.prev=tail;
        }
        if(head==null)
            head=node;
        tail=node;
        size+=1;
    }
    public void insertAtIndex(int val,int index){
        if(index==0)
            insertFirst(val);
        else if(index==size)
            insertLast(val);
        else {
            Node temp=head;
            for (int i=0;i<index-1;i++)
                temp=temp.next;
            Node node = new Node(val,temp.next,temp);
            temp.next.prev=node; temp.next=node;
            size+=1;
        }
    }
}
