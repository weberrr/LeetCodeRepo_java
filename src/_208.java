import java.util.HashMap;

/**
 * 实现 Trie (前缀树)
 *
 * @author wangz
 * @date 2018/10/23
 */
public class _208 {


    static class Tire {
        class Node {
            char value;
            boolean leaf;
            HashMap<Character, Node> children = new HashMap<>();

            Node(char c) {
                this.value = c;
            }

            Node() {
            }
        }

        private Node root;

        public Tire() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] chars = word.toCharArray();
            Node theNode = root;
            for (char c : chars) {
                if (!theNode.leaf) theNode.leaf = false;
                if (theNode.children.containsKey(c)) {
                    theNode = theNode.children.get(c);
                } else {
                    Node newNode = new Node(c);
                    theNode.children.put(c, newNode);
                    theNode = newNode;
                }
            }
            theNode.leaf = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            Node theNode = root;
            for (char c : chars) {
                if (theNode.children.containsKey(c)) {
                    theNode = theNode.children.get(c);
                } else {
                    return false;
                }
            }
            return theNode.leaf;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            Node theNode = root;
            for (char c : chars) {
                if (theNode.children.containsKey(c)) {
                    theNode = theNode.children.get(c);
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Tire obj = new Tire();
        String word = "apple";
        String word2 = "app";
        String word3 = "apps";
        obj.insert(word);
        boolean param_2 = obj.search(word);
        System.out.println(param_2);
        obj.insert(word2);
        boolean param_4 = obj.search(word2);
        System.out.println(param_4);
        obj.insert(word3);
        boolean param_3 = obj.search(word2);
        System.out.println(param_3);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
