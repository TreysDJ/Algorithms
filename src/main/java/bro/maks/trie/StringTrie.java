package bro.maks.trie;

public class StringTrie {
    private static class Node {
        Node[] children = new Node[26];
        int countAllKeys;
        int countEndKeys;
    }

    private final Node root = new Node();

    public void insert(String word) {
        Node node = root;
        node.countAllKeys++;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                node.children[c] = new Node();
            }
            node = node.children[c];
            node.countAllKeys++;
        }
        node.countEndKeys++;
    }

    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                return false;
            }
            node = node.children[c];
        }
        return node.countEndKeys > 0;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                return false;
            }
            node = node.children[c];
        }
        return true;
    }

    public boolean delete(String word) {
        if (!search(word)) {
            return false;
        }

        Node node = root;
        node.countAllKeys--;

        for (char c : word.toCharArray()) {
            c -= 'a';
            Node child = node.children[c];
            child.countAllKeys--;

            if (child.countAllKeys == 0) {
                node.children[c] = null;
                return true;
            }
            node = child;
        }
        node.countEndKeys--;
        return true;
    }
}
