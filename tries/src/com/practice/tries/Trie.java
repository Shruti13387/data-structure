package com.practice.tries;

public class Trie {

    private TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    public int getIndex(char x){
        return x - 'a';
    }

    //Function to get root
    public TrieNode getRoot() {
        return root;
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

    //Helper Function to return true if currentNode does not have any children
    private boolean hasNoChildren(TrieNode currentNode){
        for (int i = 0; i < currentNode.childNode.length; i++){
            if ((currentNode.childNode[i]) != null)
                return false;
        }
        return true;
    }

    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level){
        boolean deletedSelf = false;

        if(currentNode == null){
            System.out.println("Key doesn't exist");
            return deletedSelf;
        }


        //Base Case: If we have reached at the node which points to the alphabet at the end of the key.
        if (level == length){
            //If there are no nodes ahead of this node in this path
            //Then we can delete this node
            if (hasNoChildren(currentNode)){
                deletedSelf = true;
            }
            //If there are nodes ahead of currentNode in this path
            //Then we cannot delete currentNode. We simply unmark this as leaf
            else
            {
                currentNode.unMarkAsLeafNode();
                deletedSelf = false;
            }
        }
        else
        {
            TrieNode childNode = currentNode.childNode[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);
            if (childDeleted)
            {
                //Making children pointer also null: since child is deleted
                currentNode.childNode[getIndex(key.charAt(level))] = null;
                //If currentNode is leaf node that means currntNode is part of another key
                //and hence we can not delete this node and it's parent path nodes
                if (currentNode.isEndNode){
                    deletedSelf = false;
                }
                //If childNode is deleted but if currentNode has more children then currentNode must be part of another key.
                //So, we cannot delete currenNode
                else if (!hasNoChildren(currentNode)){
                    deletedSelf = false;
                }
                //Else we can delete currentNode
                else{
                    deletedSelf = true;
                }
            }
            else
            {
                deletedSelf = false;
            }
        }
        return deletedSelf;
    }
    public void delete(String key){
        if ((root == null) || (key == null)){
            System.out.println("Null key or Empty trie error");
            return;
        }
        deleteHelper(key, root, key.length(), 0);
    }
}
