package hacking;

import cracking.Trie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTrie {

    @Test
    public void givenString_thenSomething() {
        String[] s = {"foobar"};
        Trie t = new Trie(s);
        System.out.println(t);
    }

}
