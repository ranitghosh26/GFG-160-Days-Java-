public class Insertion {
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
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
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
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("thee"));   // true
        System.out.println(search("thor"));    // false
        System.out.println(search("there"));   // true
        System.out.println(search("an"));      // false
    }
}

// Time Complexity: O(L) for each insertion, 
// where L is the length of the word being inserted.