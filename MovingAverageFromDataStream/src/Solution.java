import java.util.Deque;
import java.util.LinkedList;

class MovingAverage {
    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        System.out.println(ma.next(3));
        System.out.println(ma.next(4));
        System.out.println(ma.next(6));
        System.out.println(ma.next(1));
    }

    // Use a Deque to hold the data coming in
    // Use a sum variable to store the current sum of all values in deque
    // When a new value comes in, check if the size of Deque is equal to the limit? If so, decrease the removed value in the sum and poll out first from deque. Then, sum up the new value and insert into deque.
    // Then, return average: (double) sum / deque.size()
    // Time: O(1), Space: O(n)

    int capacity;
    Deque<Integer> deque = new LinkedList();
    int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.capacity = size;
        this.sum = 0;
    }

    public double next(int val) {
        if(deque.size() == capacity) {
            sum -= deque.pollFirst();
        }
        deque.offerLast(val);
        sum += val;

        return (double) sum / deque.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
