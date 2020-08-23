// Use Doubly Linked List to implement the LRU cache
// Use HashMap to record <key, Node> in the LRU cache
// put(int key): Add an entry to the LRU cache. Consider: a. Entry exists b. capacity reached
// get(int key): Return the value of a key in LRU cache. Return -1 if not found
// insert(Node n): Insert a node to the head of DLL, update the map
// remove(Node n): Remove a node in the DLL, update the map

import java.util.HashMap;

public class LRUCache {
    class Node {
        private int key;
        private int val;
        private Node prev;
        private Node next;
        public Node(int key, int value) {
            this.key = key;
            this.val = value;
            this.prev = null;
            this.next = null;
        }
    }

    private HashMap<Integer, Node> map;
    private int cap;
    private int size;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.map = new HashMap();
        this.head = null;
        this.tail = null;
    }

    public void put(int key, int value) {
        Node n = new Node(key, value);
        if(map.containsKey(key)) {
            this.remove(n);
        }
        else if(this.size == this.cap) {
            this.remove(this.tail);
        }

        this.insert(n);
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);
        this.remove(n);
        this.insert(n);
        return n.val;
    }

    public void insert(Node n) {
        if(this.head == null) {
            this.head = n;
            this.tail = n;
        }
        else {
            n.next = head;
            head.prev = n;
            head = head.prev;
        }

        this.map.put(n.key, n);
        this.size++;
    }

    public void remove(Node n) {
        if(n.prev != null) {
            n.prev.next = n.next;
        }
        if(n.next != null) {
            n.next.prev = n.prev;
        }
        if(n == this.head) {
            this.head = this.head.next;
        }
        if(n == this.tail) {
            this.tail = this.tail.prev;
        }

        n.prev = null;
        n.next = null;
        this.map.remove(n.key);
        this.size--;
    }
}
