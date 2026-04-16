package bro.maks.tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {

    @Test
    void insertAndSearchTrue() {
        Trie trie = new Trie();

        trie.insert("коко");

        assertTrue(trie.search("коко"));
    }

    @Test
    void searchFalseIfNotInserted() {
        Trie trie = new Trie();

        trie.insert("коко");

        assertFalse(trie.search("бравл"));
        assertFalse(trie.search("старс"));
        assertTrue(trie.search("коко"));
    }

    @Test
    void startsWithTrue() {
        Trie trie = new Trie();

        trie.insert("бравл");

        assertTrue(trie.startsWith("бра"));
        assertTrue(trie.startsWith("брав"));
        assertTrue(trie.startsWith("бравл"));
    }

    @Test
    void startsWithFalse() {
        Trie trie = new Trie();

        trie.insert("бравл");

        assertFalse(trie.startsWith("старс"));
        assertFalse(trie.startsWith("бро"));
        assertFalse(trie.startsWith("братан"));
    }

    @Test
    void searchFalseIfEmptyTrie() {
        Trie trie = new Trie();

        assertFalse(trie.search("бравл"));
        assertFalse(trie.search("старс"));
    }
}
