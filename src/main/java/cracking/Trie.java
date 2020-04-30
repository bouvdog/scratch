package cracking;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

public class Trie {
    private TrieNode root;

    public Trie(String[] list) {
        root = new TrieNode();
        for (String word : list) {
            root.addWord(word);
        }
    }

    public TrieNode getRoot() {
        return root;
    }

    public boolean contains(String prefix) {
        return contains(prefix, false);
    }

    public boolean contains(String prefix, boolean exact) {
        TrieNode lastNode = root;
        int i = 0;
        for (i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getChild(prefix.charAt(i));
            if (lastNode == null) {
                return false;
            }
        }
        return !exact || lastNode.terminates();
    }
}
