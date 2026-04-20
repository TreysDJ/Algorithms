package bro.maks.BinarySearchTree;

public class BinarySearchTree {
    public Node root;

    public static class Node {
        public int data;
        public int key;
        Node left, right;

        public Node(int key, int data) {
            this.key = key;
            this.data = data;
        }
    }

    public Node insert(Node root, int key, int data) {
        if (root == null) {
            return new Node(key, data);
        } else {
            if (key > root.key) {
                root.right = insert(root.right, key, data);
            } else if (key < root.key) {
                root.left = insert(root.left, key, data);
            } else {
                root.data = data;
            }
        }
        return root;
    }

    public Node remove(Node root, int key) {
        if (root == null) {
            return null;
        } else {
            if (key > root.key) {
                root.right = remove(root.right, key);
            } else if (key < root.key) {
                root.left = remove(root.left, key);
            } else {
                if (root.right == null && root.left == null) {
                    return null;
                } else if (root.right == null) {
                    return root.left;
                } else if (root.left == null) {
                    return root.right;
                } else {
                    Node minRoot = root.right;
                    while (minRoot.left != null) {
                        minRoot = minRoot.left;
                    }
                    root.key = minRoot.key;
                    root.data = minRoot.data;
                    root.right = remove(root.right, minRoot.key);
                }
            }
        }
        return root;
    }

    public Node find(Node root, int key) {
        if (root == null) {
            return null;
        } else {
            if (key == root.key) {
                return root;
            } else if (key > root.key) {
                return find(root.right, key);
            } else {
                return find(root.left, key);
            }
        }
    }
}
