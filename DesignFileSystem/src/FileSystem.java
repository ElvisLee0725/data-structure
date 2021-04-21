// You are asked to design a file system that allows you to create new paths and associate them with different values.
//
//The format of a path is one or more concatenated strings of the form: / followed by one or more lowercase English letters. For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string "" and "/" are not.
//
//Implement the FileSystem class:
//
//bool createPath(string path, int value) Creates a new path and associates a value to it if possible and returns true. Returns false if the path already exists or its parent path doesn't exist.
//int get(string path) Returns the value associated with path or returns -1 if the path doesn't exist.

import java.util.HashMap;

// Use HashMap to store <File Path, Value>
// createPath(): Check if path exists? If so return false. Then, get its parent path and see if it's not root and exists already? If not, return false. Else, create new entry in map
// get(): Get the value from map. If path doesn't exist, return -1
class FileSystem {
    HashMap<String, Integer> map;
    public FileSystem() {
        this.map = new HashMap();
    }

    public boolean createPath(String path, int value) {
        if(path.isEmpty() || path.equals("/") || map.containsKey(path)) {
            return false;
        }

        int lastSlash = path.lastIndexOf("/");
        String parent = path.substring(0, lastSlash);
        // If parent path is not "/" and already exist, return false 
        if(parent.length() > 0 && !map.containsKey(parent)) {
            return false;
        }

        map.put(path, value);
        return true;
    }

    public int get(String path) {
        if(map.containsKey(path)) {
            return map.get(path);
        }
        return -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */