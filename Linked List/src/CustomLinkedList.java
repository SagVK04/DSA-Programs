import java.util.SortedMap;

public class CustomLinkedList {
    private int size;
    public CustomLinkedList(){
        size=0;
    }
    private class Node{ //Structure of node is hidden
        private int val;
        private Node next;
        public Node(int value){
            val=value;
        }
        public Node(int val, Node next){
            this.val = val; this.next = next;
        }
    }
    private Node head;
    private Node tail;
    public void insertAtFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head=node;
        if(tail==null)
            tail=head;
        size=size+1;
    }
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
    public void insert(int val){
        if(tail==null) {
            insertAtFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next=node;
        tail=node;
        size+=1;
    }
    public void insertAtIndex(int index,int val){
        if(index==0)
            insertAtFirst(val);
        else if(index==size)
            insert(val);
        else {
            Node temp1 = head;
            for(int i=0;i<index-1;i++)
                temp1=temp1.next;
            Node temp = new Node(val,temp1.next);
            temp1.next=temp;
            size+=1;
        }
    }
    public int deleteFirst() throws LLException{
        int removed=-1;
        if(head==null)
            throw new LLException("Linked List is empty!");
        else{
            removed=head.val;
            head=head.next;
            if(head==null)
                tail=null;
        }
        size-=1;
        return removed;
    }
    public int deleteLast() throws LLException{
        int removed=-1;
        if(head==null)
            throw new LLException("Linked List is empty!");
        if(size==1)
            return deleteFirst();
        else {
            Node temp = head;
            while (temp.next.next != null)
                temp = temp.next;
            removed=temp.next.val;
            tail=temp;
            temp.next=null;
            size-=1;
        }
        return removed;
    }
    public int deleteIndex(int index) throws LLException{
        int removed=-1;
        if(head==null)
            throw new LLException("Linked List is empty!");
        else if(index==0)
            return deleteFirst();
        else if (index==size)
            return deleteLast();
        else{
            Node temp = head;
            for(int i=0;i<index-1;i++)
                temp=temp.next;
            removed=temp.next.val;
            temp.next=temp.next.next;
            size-=1;
            System.out.println("Deleting index "+index+" ...");
        }
        return removed;
    }
}
