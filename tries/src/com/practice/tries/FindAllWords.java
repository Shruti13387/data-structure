package com.practice.tries;

import java.util.ArrayList;
import java.util.List;

public class FindAllWords {

    /**
     *
     */
    public static void findWords(TrieNode root, List<String> words, char[] word, int level) {

        if (root.isEndNode) {
            String temp = "";
            for (int i = 0; i < level; i++) {
                temp += Character.toString(word[i]);
            }
            words.add(temp);
        }

        for (int i = 0; i < 26; i++) {
            if (root.childNode[i] != null) {
                word[level] = (char) (i + 'a');
                findWords(root.childNode[i], words, word, level + 1);
            }
        }
    }

    public static ArrayList<String> findWords(TrieNode root) {
        ArrayList<String> result = new ArrayList<String>();
        char[] chararr = new char[20];
        findWords(root, result, chararr, 0);
        return result;
    }
}
