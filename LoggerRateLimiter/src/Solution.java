import java.util.HashMap;

// Use a HashMap to store the <Message, the timestamp that it can be called next time>
// When a log comes, check if the message is in the hashmap? If not, add it to hashmap and return true
// If the message is in hashmap, check if the current timestamp is greater or equal to the value of that message? If so, return true and update the timestamp; Otherwise, return false
// Time: O(1), Space: O(n)
class Logger {
    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        this.map = new HashMap();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)) {
            map.put(message, timestamp + 10);
            return true;
        }
        else {
            if(timestamp >= map.get(message)) {
                map.put(message, timestamp + 10);
                return true;
            }
            else {
                return false;
            }
        }
    }
}
