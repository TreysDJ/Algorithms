package bro.maks.tree;

/**
 * Базовый класс дженерик-дерева
 */
class BinaryTree<T> {
    Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    private Node<T> getLeft() {
        if (root.left != null) {
            return root.left;
        } else {
            return null;
        }
    }

    private Node<T> getRight() {
        if (root.right != null) {
            return root.right;
        } else {
            return null;
        }
    }
}
