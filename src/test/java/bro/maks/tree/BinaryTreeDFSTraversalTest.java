package bro.maks.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeDFSTraversalTest {
    BinaryTree<Integer> tree;

    /*
       Подготавливаем дерево перед каждым тестом:
             1
           /   \
          2     3
         / \
        4   5
    */
    @BeforeEach
    void setUp() {
        tree = new BinaryTree<>();
        tree.root = new Node<>(1);
        tree.root.left = new Node<>(2);
        tree.root.right = new Node<>(3);
        tree.root.left.left = new Node<>(4);
        tree.root.left.right = new Node<>(5);
    }

    @Test
    void testPreOrder() {
        BinaryTreeDFSTraversal<Integer> traversal = new BinaryTreeDFSTraversal<>(tree);
        List<Integer> result = new ArrayList<>();

        traversal.preOrder(tree.root, result::add);

        assertEquals(List.of(1, 2, 4, 5, 3), result, "Pre-order traversal failed");
    }

    @Test
    void testInOrder() {
        BinaryTreeDFSTraversal<Integer> traversal = new BinaryTreeDFSTraversal<>(tree);
        List<Integer> result = new ArrayList<>();

        traversal.inOrder(tree.root, result::add);

        assertEquals(List.of(4, 2, 5, 1, 3), result, "In-order traversal failed");
    }

    @Test
    void testPostOrder() {
        BinaryTreeDFSTraversal<Integer> traversal = new BinaryTreeDFSTraversal<>(tree);
        List<Integer> result = new ArrayList<>();

        traversal.postOrder(tree.root, result::add);

        assertEquals(List.of(4, 5, 2, 3, 1), result, "Post-order traversal failed");
    }
}