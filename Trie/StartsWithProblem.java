public class StartsWithProblem {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false; // end of word

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    
    // Insertion Method 
    // Time Complexity: O(L) for each insertion, 
    // where L is the length of the word being inserted.

    public static void insert(String word) {
        int level=0;
        int len = word.length();
        int idx = 0;
        Node curr = root;
        for (; level <len; level++) {
            idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true; // mark end of word
    }

    // Searching Method
    // Time Complexity: O(L) for each search,
    // where L is the length of the word being searched.
    public static boolean search(String key) {
        int level = 0;
        int len = key.length();
        int idx = 0;

        Node curr = root;
        for (; level < len; level++) {
            idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static boolean startsWith(String prefix) {
        // int level = 0;
        // int len = prefix.length();
        // int idx = 0;

        Node curr = root;
        for (int i=0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String arr[] = {"apple", "app", "mango", "man", "woman"};
        String prefix1 = "app";
        String prefix2 = "moon";

        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        System.out.println(startsWith(prefix1)); // true
        System.out.println(startsWith(prefix2)); // false
    }
}
