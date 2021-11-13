package com.practice.tries;

public class CountTotalWords {

    public static int countTotalWords(TrieNode tries){
        int result = 0;

        if(tries.isEndNode){
            result++;
        }

        for(int i = 0;i < 26; i++){
            if(tries.childNode[i] != null)
                result += countTotalWords(tries.childNode[i]);
        }
        return result;
    }


}

