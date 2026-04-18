package bro.maks.tree;

import java.util.function.Consumer;

/**
 * Класс-враппер (декоратор) для выполнения DFS обхода.
 */
class BinaryTreeDFSTraversal<T> {
    private final BinaryTree<T> tree;

    public BinaryTreeDFSTraversal(BinaryTree<T> tree) {
        this.tree = tree;
    }

    /**
     * Прямой обход (Pre-order)
     */
        public void preOrder(Node<T> node, Consumer<T> action) {
            if (node == null) {
                return;
            }

            action.accept(node.data);

            if (node.left != null) {
                preOrder(node.left, action);
            }

            if (node.right != null) {
                preOrder(node.right, action);
            }
        }

    /**
     * Симметричный обход (In-order)
     */
    public void inOrder(Node<T> node, Consumer<T> action) {
        // Логика: Лево -> Корень -> Право
        if (node == null) {
            return;
        }

        if (node.left != null) {
            inOrder(node.left, action);
        }

        action.accept(node.data);

        if(node.right != null) {
            inOrder(node.right, action);
        }
    }

    /**
     * Обратный обход (Post-order)
     */
    public void postOrder(Node<T> node, Consumer<T> action) {
        // Логика: Лево -> Право -> Корень
        if (node == null) {
            return;
        }

        if (node.left != null) {
            postOrder(node.left, action);
        }

        if(node.right != null) {
            postOrder(node.right, action);
        }

        action.accept(node.data);
    }
}

