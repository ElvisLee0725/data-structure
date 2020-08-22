// APIs:
// hash(int key): To get the index of the key to be stored at
// find(Node head, int key): Find a key's location in a bucket, returns a dummy (preivous node)
// Case 1: dummy is null, then head is target
// Case 2: dummy.next is null, target is not in the LinkedList
// Case 3: dummy.next is not null, target is the next node

// put(int key, int value): Append a new Node or update the value of Node with the same key
// get(int key): Return the value of a key, return -1 if not found
// remove(int key): Remove a key if it exists

public class MyHashMap {
    class Node {
        private int key;
        private int val;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.val = value;
            this.next = null;
        }
    }

    private Node [] array;

    public MyHashMap() {
        this.array = new Node[100];
    }

    public int hash(int k) {
        final int prime = 31;
        int res = 0;

        while(k != 0) {
            res = res + k % 10 * prime;
            k /= 10;
        }
        return (res & 0x7fffffff) % this.array.length;  // Guarantee the res is positive
    }

    public Node find(Node head, int key) {
        Node dummy = null;
        while(head != null && head.key != key) {
            dummy = head;
            head = head.next;
        }

        return dummy;
    }

    public void put(int key, int value) {
        int index = this.hash(key);
        Node n = new Node(key, value);
        if(this.array[index] == null) {
            this.array[index] = n;
            return ;
        }

        Node prev = this.find(this.array[index], key);
        if(prev == null) {
            this.array[index].val = value;
        }
        else if(prev.next == null){
            prev.next = n;
        }
        else {
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int index = this.hash(key);

        if(this.array[index] != null) {
            Node prev = this.find(this.array[index], key);
            if(prev == null) {
                return this.array[index].val;
            }
            else if(prev.next != null) {
                return prev.next.val;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = this.hash(key);

        if(this.array[index] != null) {
            Node prev = this.find(this.array[index], key);
            if(prev == null) {
                this.array[index] = this.array[index].next;
            }
            else {
                prev.next = prev.next.next;
            }
        }
    }
}
