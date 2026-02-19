import java.util.HashMap;

public class LRUCache {
    class Node{
        int key; int val;
        Node prev; Node next;
        public Node(){ prev = null; next = null; }
        public Node(int k, int value){
            key = k; val = value;
            prev = null; next = null;
        }
    }
    HashMap<Integer,Node> map; int cap;
    Node head; Node tail;
    public LRUCache(int capacity){
        cap = capacity; map = new HashMap<>();
        head = new Node(); tail = new Node();
        head.next = tail; tail.prev = head;
    }
    public int get(int key){
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        deleteNode(node); insertFirst(node);
        return node.val;
    }
    public void put(int key, int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            deleteNode(node); insertFirst(node);
        }
        else{
            if(map.size() == cap){
                Node node = tail.prev;
                map.remove(node.key);
                deleteNode(node);
            }
            Node node = new Node(key,value);
            map.put(key,node);
            insertFirst(node);
        }
    }
    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insertFirst(Node node){
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        node.prev.next = node;
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // Capacity of 2
        cache.put(1, 1); // Cache: {1=1}
        cache.put(2, 2); // Cache: {1=1, 2=2}
        System.out.println("Get 1: " + cache.get(1)); // Returns 1 (1 is now MRU)
        cache.put(3, 3); // Evicts key 2 (Least Recently Used)
        System.out.println("Get 2 (should be -1): " + cache.get(2));
        cache.put(4, 4); // Evicts key 1
        System.out.println("Get 1 (should be -1): " + cache.get(1));
        System.out.println("Get 3: " + cache.get(3)); // Returns 3
        System.out.println("Get 4: " + cache.get(4)); // Returns 4
    }
}
