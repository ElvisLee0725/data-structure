// Use a HashMap to store <val, index>, and use a List<Integer> to store each number
// insert(): check hashmap, if not exist, create in map and List
// remove(): check hashmap, if exist, swap the last val to index, always delete the last element so Time: O(1)
// getRandom(): Get a random index from 0 to list.size()-1 and return it

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Time: O(1), Space: O(n)
class RandomizedSet {

    HashMap<Integer, Integer> map;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap();
        this.list = new ArrayList();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        int lastVal = list.get(list.size()-1);
        int index = map.get(val);
        list.set(index, lastVal);
        map.put(lastVal, index);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = (int) (Math.random() * list.size());
        return list.get(index);
    }
}
