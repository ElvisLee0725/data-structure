class MyHashSet {
    class Node{
        private int key;
        private Node next;
        public Node(int key) {
            this.key = key;
        }
    }

    private Node [] array;
    private int size;
    private final double LOAD_FACTOR;
    private final int prime;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.array = new Node[100];
        this.size = 0;
        this.LOAD_FACTOR = 0.75;
        this.prime = 31;
    }

    public int hash(int key, int len) {
        int res = 0;
        while(key != 0) {
            res = res + (key % 10) * this.prime;
            key /= 10;
        }
        return res % len;
    }

    public void rehash() {
        Node [] newArr = new Node[this.array.length * 2];
        for(Node cur : this.array) {
            while(cur != null) {
                int index = this.hash(cur.key, newArr.length);
                Node n = new Node(cur.key);
                if(newArr[index] == null) {
                    newArr[index] = n;
                }
                else {
                    Node dummy = newArr[index];
                    while(dummy.next != null) {
                        dummy = dummy.next;
                    }
                    dummy.next = n;
                }
                cur = cur.next;
            }
        }
        this.array = newArr;
    }

    // The dummy returned is the prev node. The next is target to find
    public Node find(Node head, int k) {
        Node dummy = null;
        while(head != null && head.key != k) {
            dummy = head;
            head = head.next;
        }
        return dummy;
    }

    public void add(int key) {
        if((double) this.size / (double) this.array.length > this.LOAD_FACTOR) {
            this.rehash();
        }

        int index = this.hash(key, this.array.length);
        Node n = new Node(key);
        if(this.array[index] == null) {
            this.array[index] = n;
            this.size++;
        }
        else {
            Node prev = this.find(this.array[index], key);
            // If prev is null or prev.next isn't null, then key is already inside
            if(prev != null && prev.next == null) {
                prev.next = n;
                this.size++;
            }
        }
    }

    public void remove(int key) {
        int index = this.hash(key, this.array.length);
        Node prev = this.find(this.array[index], key);
        if(this.array[index] != null) {
            if(prev == null) {
                this.array[index] = this.array[index].next;
            }
            else if(prev.next != null) {
                prev.next = prev.next.next;
            }
            this.size--;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = this.hash(key, this.array.length);
        Node prev = this.find(this.array[index], key);
        if(this.array[index] != null && (prev == null || prev.next != null)) {
            return true;
        }
        return false;
    }
}
