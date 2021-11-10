package com.practice.tries;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys to insert: "+ Arrays.toString(keys) + "\n");

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
        {
            t.insert(keys[i]);
            System.out.println("\""+ keys[i]+ "\" " + "Inserted.");
        }

        // Search for different keys
        if(t.search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(t.search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(t.search("abc") == true)
            System.out.println("abc --- " + output[1]);
        else System.out.println("abc --- " + output[0]);

        // Search for different keys and delete if found
        if(t.search("the") == true)
        {
            System.out.println("the --- " + output[1]);
            t.delete("the");
            System.out.println("Deleted key \"the\"");
        }
        else System.out.println("the --- " + output[0]);

        if(t.search("these") == true)
        {
            System.out.println("these --- " + output[1]);
            t.delete("these");
            System.out.println("Deleted key \"these\"");
        }
        else System.out.println("these --- " + output[0]);

        if(t.search("abc") == true)
        {
            System.out.println("abc --- " + output[1]);
            t.delete("abc");
            System.out.println("Deleted key \"abc\"");
        }
        else System.out.println("abc --- " + output[0]);

        // check if the string has deleted correctly or still present
        if(t.search("abc") == true)
            System.out.println("abc --- " + output[1]);
        else System.out.println("abc --- " + output[0]);

    }
}
