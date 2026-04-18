package bro.maks.trie;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTrieTest {

    @Test
    void searchInEmptyTrie() {
        BinaryTrie trie = new BinaryTrie();
        assertFalse(trie.search(1));
    }

    @Test
    void insertAndSearchSingleValue() {
        BinaryTrie trie = new BinaryTrie();

        trie.insert(1);

        assertTrue(trie.search(1));
        assertFalse(trie.search(2));
    }

    @Test
    void multipleValues() {
        BinaryTrie trie = new BinaryTrie();

        trie.insert(1);
        trie.insert(-1);

        assertTrue(trie.search(1));
        assertTrue(trie.search(-1));
        assertFalse(trie.search(0));
    }

    @Test
    void duplicateInsert() {
        BinaryTrie trie = new BinaryTrie();

        trie.insert(5);
        trie.insert(5);

        assertFalse(trie.search(10));
        assertTrue(trie.search(5));
    }

    @Test
    void deleteWhenElementsExist() {
        BinaryTrie trie = new BinaryTrie();
        trie.insert(2);
        trie.insert(3);

        assertTrue(trie.delete(2));
        assertFalse(trie.search(2));
        assertTrue(trie.search(3));
    }

    @Test
    void deleteWhenElementsDoNotExist() {
        BinaryTrie trie = new BinaryTrie();

        assertFalse(trie.delete(1));

        trie.insert(1);
        assertFalse(trie.delete(2));
        assertTrue(trie.search(1));
    }
}