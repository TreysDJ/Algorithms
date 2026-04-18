package bro.maks.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BinaryTreeBFSTraversalTest {
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
    void testBfs() {
        BinaryTreeBFSTraversal<Integer> traversal = new BinaryTreeBFSTraversal<>(tree);
        List<Integer> result = new ArrayList<>();

        traversal.bfs(x -> result.add(x));

        assertEquals(List.of(1, 2, 3, 4, 5), result, "BFS (Level-order) failed");
    }
}
