package bro.maks.bst;

import bro.maks.BinarySearchTree.BinarySearchTree;
import bro.maks.BinarySearchTree.BinarySearchTree.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BinarySearchTreeTest {
    private BinarySearchTree tree;

    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree();
    }

    @Test
    void removeWhenTreeIsEmptyTest() {
        Node node = tree.remove(tree.root, 10);

        Assertions.assertEquals(null, node);
    }

    @Test
    void removeWhenTreeIsNotEmpty() {
        tree.root = tree.insert(tree.root, 5, 10);
        tree.root = tree.insert(tree.root, 6, 9);
        tree.root = tree.remove(tree.root, 5);

        tree.root = tree.remove(tree.root, 5);

        assertNull(tree.find(tree.root, 5));
        assertNotNull(tree.find(tree.root, 6));

        tree.root = tree.remove(tree.root, 6);
        assertNull(tree.find(tree.root, 5));
        assertNull(tree.find(tree.root, 6));
    }

    @Test
    void removeFull() {
        tree.root = tree.insert(tree.root, 5, 10);
        tree.root = tree.insert(tree.root, 6, 9);

        tree.root = tree.remove(tree.root, 5);
        tree.root = tree.remove(tree.root, 6);

        assertNull(tree.find(tree.root, 5));
        assertNull(tree.find(tree.root, 6));
    }

    @Test
    void findWhenTreeIsEmpty() {
        Node node = tree.find(tree.root, 5);
        assertNull(node);
    }

    @Test
    void findDefault() {
        tree.root = tree.insert(tree.root, 5, 50);

        Node node = tree.find(tree.root, 5);

        assertNotNull(node);
    }

    @Test
    void findWhenSomeEqualsElements() {
        tree.root = tree.insert(tree.root, 6, 9);
        tree.root = tree.insert(tree.root, 6, 10);

        Node node = tree.find(tree.root, 6);

        Assertions.assertEquals(node.data, 10);

    }
}
