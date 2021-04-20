// Design a stack which supports the following operations.
//
//Implement the CustomStack class:
//
//CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack or do nothing if the stack reached the maxSize.
//void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
//int pop() Pops and returns the top of stack or -1 if the stack is empty.
//void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, just increment all the elements in the stack.

import java.util.Deque;
import java.util.LinkedList;

// Implement with a Deque<Integer>, record the max size when initialize
// push():
// Check if current size has reached max size? if yes, do nothing. Else, push the value. Time: O(1)
// pop():
// Check if the deque is empty? If so, return -1. Else, pop from the top. Time: O(1)
// increment():
// Pop from the head of deque k times or the size of current deque which is smaller to a tmp deque and add val. Then, pop from tmp back to deque. Time: O(k)
// Time: O(k), Space: O(n)
class CustomStack {
    Deque<Integer> deque;
    Deque<Integer> tmp;
    int maxSize;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.deque = new LinkedList();
        this.tmp = new LinkedList();
    }

    public void push(int x) {
        if(deque.size() == maxSize) {
            return ;
        }
        deque.offerLast(x);
    }

    public int pop() {
        if(deque.isEmpty()) {
            return -1;
        }
        return deque.pollLast();
    }

    public void increment(int k, int val) {
        int curSize = deque.size();
        for(int i = 0; i < Math.min(k, curSize); i++) {
            tmp.offerLast(deque.pollFirst() + val);
        }
        while(!tmp.isEmpty()) {
            deque.offerFirst(tmp.pollLast());
        }
    }
}
