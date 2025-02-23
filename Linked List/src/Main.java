public class Main {
    public static void main(String[] args) throws LLException{
        CustomLinkedList list = new CustomLinkedList();
        /*list.insertAtFirst(5);
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
        list.reverse();*/
        list.insert(1);
        list.insert(1);
        list.insert(1);
        list.insert(2);
        list.insert(4);
        list.insert(4);
        list.display();
        list.deleteDuplicates();
        list.display();
    }
}
