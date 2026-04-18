package bro.maks.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * Класс-враппер (декоратор) для выполнения BFS обхода.
 */
class BinaryTreeBFSTraversal<T> {
    private final BinaryTree<T> tree;

    public BinaryTreeBFSTraversal(BinaryTree<T> tree) {
        this.tree = tree;
    }

    public Node<T> getRoot() {
        if (this.tree.root != null) {
            return this.tree.root;
        } else {
            return null;
        }
    }

    /**
     * Обход в ширину (BFS, Level-order)
     */
    public void bfs(Consumer<T> action) {
        // Логика: По уровням (используя Queue)
        if (this.tree.root == null) {
            return;
        }
        Queue<Node<T>> nodes = new LinkedList<>();
        nodes.add(this.tree.root);

        while (!(nodes.isEmpty())) {
            Node<T> cur = nodes.poll();
            action.accept(cur.data);

            if (cur.left != null) {
                nodes.add(cur.left);
            }
            if (cur.right != null) {
                nodes.add(cur.right);
            }
        }
    }
}

