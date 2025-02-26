public class CustomLinkedList {
    private static int size;

    public CustomLinkedList() {
        size = 0;
    }

    private class Node { //Structure of node is hidden
        private int val;
        private Node next;

        public Node(int value) {
            val = value;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    public void insertAtFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null)
            tail = head;
        size = size + 1;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
        System.out.println("Size of linked list: " + size);
    }

    public void reverse() {
        Node temp = head;
        Node prev = null;
        Node after = null;
        while (temp != null) {
            after = temp.next; //Preserve the rest linked list
            temp.next = prev; //Reverse the link
            prev = temp;//Move prev
            temp = after;//Move temp
        }
        System.out.print("Reverse is: ");
        while (prev != null) {
            System.out.print(prev.val + "->");
            prev = prev.next;
        }
        System.out.print("null");
        System.out.println();
        System.out.println("Size of linked list: " + size);
    }

    public void reverseRec(){
        newreverse(head);
        display();
    }
    private void newreverse(Node node){
        if(node==tail) {
            head = tail;
            return;
        }
        newreverse(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }

    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size += 1;
            return temp;
        }
        node.next = insertRec(val, index - 1, node.next);
        return node;
    }

    public void insert(int val) {
        if (tail == null) {
            insertAtFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void insertAtIndex(int index, int val) {
        if (index == 0)
            insertAtFirst(val);
        else if (index == size)
            insert(val);
        else {
            Node temp1 = head;
            for (int i = 0; i < index - 1; i++)
                temp1 = temp1.next;
            Node temp = new Node(val, temp1.next);
            temp1.next = temp;
            size += 1;
        }
    }

    public int deleteFirst() throws LLException {
        int removed = -1;
        if (head == null)
            throw new LLException("Linked List is empty!");
        else {
            removed = head.val;
            head = head.next;
            if (head == null)
                tail = null;
        }
        size -= 1;
        return removed;
    }

    public int deleteLast() throws LLException {
        int removed = -1;
        if (head == null)
            throw new LLException("Linked List is empty!");
        if (size == 1)
            return deleteFirst();
        else {
            Node temp = head;
            while (temp.next.next != null)
                temp = temp.next;
            removed = temp.next.val;
            tail = temp;
            temp.next = null;
            size -= 1;
        }
        return removed;
    }

    public int deleteIndex(int index) throws LLException {
        int removed = -1;
        if (head == null)
            throw new LLException("Linked List is empty!");
        else if (index == 0)
            return deleteFirst();
        else if (index == size)
            return deleteLast();
        else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++)
                temp = temp.next;
            removed = temp.next.val;
            temp.next = temp.next.next;
            size -= 1;
            System.out.println("Deleting index " + index + " ...");
        }
        return removed;
    }

    public Node deleteDuplicates() {
        Node node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
                size -= 1;
            } else
                node = node.next;
        }
        tail = node;
        tail.next = null;
        return head;
    }

    public static CustomLinkedList merge(CustomLinkedList first, CustomLinkedList second) {
        Node f = first.head;
        Node s = second.head;
        CustomLinkedList ans = new CustomLinkedList();
        while (f != null && s != null) {
            if (f.val > s.val) {
                ans.insert(f.val);
                f = f.next;
            } else {
                ans.insert(s.val);
                s = s.next;
            }
        }
        while (f != null) {
            ans.insert(f.val);
            f = f.next;
        }
        while (s != null) {
            ans.insert(s.val);
            s = s.next;
        }
        return ans;
    }
}
