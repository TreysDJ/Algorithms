package bro.maks.trie;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringTrieTest {

    @Test
    void insertAndSearchTrue() {
        StringTrie stringTrie = new StringTrie();

        stringTrie.insert("brawl");

        assertTrue(stringTrie.search("brawl"));
    }

    @Test
    void searchFalseIfNotInserted() {
        StringTrie stringTrie = new StringTrie();

        stringTrie.insert("brawl");

        assertFalse(stringTrie.search("start"));
        assertFalse(stringTrie.search("stars"));
        assertTrue(stringTrie.search("brawl"));
    }

    @Test
    void startsWithTrue() {
        StringTrie stringTrie = new StringTrie();

        stringTrie.insert("treys");

        assertTrue(stringTrie.startsWith("treys"));
        assertTrue(stringTrie.startsWith("trey"));
        assertTrue(stringTrie.startsWith("tre"));
    }

    @Test
    void startsWithFalse() {
        StringTrie stringTrie = new StringTrie();

        stringTrie.insert("seaside");

        assertFalse(stringTrie.startsWith("sed"));
        assertFalse(stringTrie.startsWith("side"));
        assertFalse(stringTrie.startsWith("eas"));
    }

    @Test
    void searchFalseIfEmptyTrie() {
        StringTrie stringTrie = new StringTrie();

        assertFalse(stringTrie.search("treys"));
        assertFalse(stringTrie.search("seaside"));
    }

    @Test
    void deleteWhenWordAdd() {
        StringTrie trie = new StringTrie();
        trie.insert("cat");
        trie.insert("car");

        assertTrue(trie.delete("cat"));
        assertFalse(trie.search("cat"));
        assertTrue(trie.search("car"));
    }

    @Test
    void deleteWhenWordNotAdd() {
        StringTrie trie = new StringTrie();

        assertFalse(trie.delete("seaside"));

        trie.insert("sea");
        assertFalse(trie.delete("seas"));
        assertTrue(trie.search("sea"));
    }
}
