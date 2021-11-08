package com.practice.tries;

public class Trie {

    private TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    public int getIndex(char x){
        return x - 'a';
    }

    public void insert(String key){
        if(null==key){
            System.out.println("Null key cannot be inserted");
        }

        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        for(int level = 0; level<key.length(); level++){
            int index = getIndex(key.charAt(level));
            if(currentNode.childNode[index]==null){
                currentNode.childNode[index] = new TrieNode();
            }
            currentNode = currentNode.childNode[index];
        }
        currentNode.markAsLeaf();
    }

    public boolean search(String key){
        if(null==key){
            System.out.println("Null key cannot be inserted");
        }

        key = key.toLowerCase();
        TrieNode currentNode = this.root;

        for(int level = 0; level<key.length(); level++){
            int index = getIndex(key.charAt(level));
            if(currentNode.childNode[index]==null){
                return false;
            }
            currentNode = currentNode.childNode[index];
        }
        return currentNode.isEndNode;
    }

    public boolean delete(String key){
        if(null==key){
            System.out.println("Null key cannot be inserted");
        }

        key = key.toLowerCase();
        TrieNode currentNode = this.root;

        for(int level = 0; level<key.length(); level++){
            int index = getIndex(key.charAt(level));
            if(currentNode.childNode[index]==null){
                return false;
            }
            currentNode = currentNode.childNode[index];
        }
        return currentNode.isEndNode;
    }
}
