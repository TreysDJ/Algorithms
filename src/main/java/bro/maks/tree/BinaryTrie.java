package bro.maks.tree;

public class BinaryTrie {
    private static class Node {
        Node[] children = new Node[2];
        int countAllKeys;
        int countEndKeys;
    }

    private final Node root = new Node();

    public void insert(int num) {
        Node node = root;
        node.countAllKeys++;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new Node();
            }
            node = node.children[bit];
            node.countAllKeys++;
        }
        node.countEndKeys++;

    }

    public boolean search(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                return false;
            }
            node = node.children[bit];
        }
        return node.countEndKeys > 0;
    }

    public boolean delete(int num) {
        if (!search(num)) {
            return false;
        }

        Node node = root;
        node.countAllKeys--;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            Node child = node.children[bit];
            child.countAllKeys--;

            if (child.countAllKeys == 0) {
                node.children[bit] = null;
                return true;
            }
            node = child;
        }
        node.countEndKeys--;
        return true;
    }
}
