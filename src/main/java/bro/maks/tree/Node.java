package bro.maks.tree;

/**
 * Узел дерева с поддержкой любых типов данных
 */
class Node<T> {
    T data;
    Node<T> left, right;

    public Node(T data) {
        this.data = data;
    }
}
