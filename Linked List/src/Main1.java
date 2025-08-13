public class Main1 {
    public static void main(String[] args) throws LLException {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertLast(8);
        list.insertLast(12);
        list.insertLast(18);
        list.display();
        list.insertFirst(9);
        list.insertFirst(3);
        list.insertFirst(5);
        list.display();
        list.insertAtIndex(7,3);
        list.display();
        list.reverseLinkedList();
   }
}
