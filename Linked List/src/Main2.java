public class Main2 {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        //list.insertAtFirst(5);
        //list.insertAtFirst(3);
        list.insert(9);
        list.insert(8);
        list.insert(12);
        list.insert(18);
        //list.insertAtIndex(3,7);
        list.display();
        System.out.println("Removed item is: "+list.delete(9));
        list.display();
        System.out.println("Removed item is: "+list.delete(19));
        list.display();
        System.out.println("Removed item is: "+list.delete(8));
        list.display();
    }
}
