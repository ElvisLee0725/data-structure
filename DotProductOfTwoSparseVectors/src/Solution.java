import java.util.ArrayList;
import java.util.List;

// Store input into a List of pairs int [] {i, nums[i]}
// In dotProduct, use 2 pointers to point at both lists, while they are both valid, check if they both have the same index, if so, get product. Else, move i or j depends on which one is bigger
// Time: O(n) for create, O(L) for dotProduct. Space: O(L), L is the length of vector
class SparseVector {
    List<int []> list;
    SparseVector(int[] nums) {
        this.list = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                list.add(new int[]{i, nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int i = 0;
        int j = 0;
        int sum = 0;
        while(i < this.list.size() && j < vec.list.size()) {
            if(this.list.get(i)[0] < vec.list.get(j)[0]) {
                i++;
            }
            else if(this.list.get(i)[0] > vec.list.get(j)[0]) {
                j++;
            }
            else {
                sum += this.list.get(i)[1] * vec.list.get(j)[1];
                i++;
                j++;
            }
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
