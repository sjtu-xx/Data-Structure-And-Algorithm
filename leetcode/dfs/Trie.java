package leetcode.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树
 */
public class Trie {
    public Map<Character, Trie> childrenTrie;
    public int count;
    public boolean isEnd;
    public String word;

    public Trie() {
        childrenTrie = new HashMap<>();
    }

    public void insert(String word) {
        Trie tmpTrie = this;
        for (int i = 0; i < word.length(); i++) {
            tmpTrie.count++;
            char c = word.charAt(i);
            if (!tmpTrie.childrenTrie.containsKey(c)) {
                tmpTrie.childrenTrie.put(c, new Trie());
            }
            tmpTrie = tmpTrie.childrenTrie.get(c);
        }
        tmpTrie.count++;
        tmpTrie.isEnd = true;
        tmpTrie.word = word;
    }

    public void remove(String word) {
        Trie tmpTrie = this;
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            tmpTrie.count--;
            char c = word.charAt(i);
            if (tmpTrie.childrenTrie.get(c).count == 1) {
                tmpTrie.childrenTrie.remove(c);
                flag = true;
                break;
            } else {
                tmpTrie = tmpTrie.childrenTrie.get(c);
            }
        }
        tmpTrie.isEnd = false;
        if (tmpTrie != this && !flag) tmpTrie.count--;
    }
}
