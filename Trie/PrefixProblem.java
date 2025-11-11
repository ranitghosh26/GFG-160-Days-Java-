// Prefix Problem   --->>> [Google , Microsoft Interview Question]***
// Find shortest unique prefix for every word in a given list.
// Assume no word is prefix of another.
// arr[] = {"zebra", "dog", "duck", "dove"}
// ans = ("z", "dog", "du", "dov")


public class PrefixProblem {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false; // end of word
        int freq; // frequency of the prefix

        public Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }
    public static Node root = new Node();

    // Insertion Method
    public static void insert(String word) {
        Node cuur  = root;
        for(int i=0; i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(cuur.children[idx] == null){
                cuur.children[idx] = new Node();
            } else {
                cuur.children[idx].freq++;
            }
            cuur = cuur.children[idx];  
        }
        cuur.eow = true;
    }
    public static void findPrefix(Node root, String ans){
        if(root == null) return;

        // If this node's prefix frequency is 1, the current ans is
        // the shortest unique prefix for the word that passes here.
        if(root== null) return;
        if(root.freq == 1){
            System.out.println(ans);
            return;
        }

        // Otherwise, continue traversing children
        for(int i = 0; i < root.children.length; i++){
            if(root.children[i] != null){
                findPrefix(root.children[i], ans + (char)(i + 'a'));
            }
        }
    }
    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        for(int i=0; i<arr.length;i++){
            insert(arr[i]);

        }   
        root.freq = -1; // to avoid printing empty string as prefix
        findPrefix(root, "");

        // start traversal from root's children so prefixes begin with a letter
        // for(int i = 0; i < root.children.length; i++){
        //     if(root.children[i] != null){
        //         findPrefix(root.children[i], "" + (char)(i + 'a'));
        //     }
        // }
    }
}
