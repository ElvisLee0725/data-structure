// Use PriorityQueue to create a minHeap
// Loop the input array. Before the current index reaches k, insert item to array
// When cur index reach k, check if the top of minHeap is smaller than current item, if so, pop it and insert cur
// Return the top of the minHeap

// Time: O(k + (n-k)logk), Space: O(k)

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int [] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.print(new Solution().findKthLargest(nums, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue(k);
        for(int i = 0; i < nums.length; i++) {
            if(i < k) {
                minHeap.offer(nums[i]);
            }
            else {
                if(nums[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
        return minHeap.poll();
    }
}
