package com.practice.tries;

public class TrieNode {

    TrieNode[] childNode;
    boolean isEndNode;
    static final int ALPHABET_SIZE = 26;

    TrieNode(){
        this.isEndNode = false;
        this.childNode = new TrieNode[ALPHABET_SIZE];
    }

    public void markAsLeaf(){
        this.isEndNode = true;
    }

    public void unMarkAsLeafNode(){
        this.isEndNode = false;
    }
}
