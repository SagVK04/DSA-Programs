public class Main {
    public static void main(String[] args) throws LLException {
        CustomLinkedList list = new CustomLinkedList();
        list.insertAtFirst(5);
        list.insertAtFirst(3);
        list.insert(9);
        list.insert(8);
        list.insert(12);
        list.insert(18);
        list.insertAtIndex(3,7);
        list.display();
        list.insertRec(99,5);
        list.display();
        System.out.println("Removed from first item is: "+list.deleteFirst());
        list.display();
        System.out.println("Removed from last item is: "+list.deleteLast());
        list.display();
        System.out.println("Removed from index item is: "+list.deleteIndex(3));
        list.display();
        list.reverseRec();
        /*CustomLinkedList first = new CustomLinkedList();
        CustomLinkedList second = new CustomLinkedList();

        first.insert(1); first.insert(3); first.insert(5);

        second.insert(1); second.insert(2); second.insert(9); second.insert(14);

        CustomLinkedList res = CustomLinkedList.merge(first,second);
        res.display();*/
    }
}
