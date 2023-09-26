package com.firman;
import java.util.Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * description of class Main
 *
 * @author firman.lasaman
 * @version v1.0.0
 */
public class Main {
    /**
     * Main function
     * @param args command line arguments
     */
    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog.The lazy dog barks, and the quick brown fox runs away.";
        System.out.println(sentence);

        System.out.println("Word Frequency Counter");
        System.out.println("Word \t\t Frequency");
        System.out.println("--------------------------");

        // split string from varaiable word with '.' and ',' and '!' as delimiter
        String[] words = sentence.split("[\\s.,!]+");
        // filter out "the" ,"The","and","is"
        words = Arrays.stream(words)
                .filter(word -> !word.equals("the") && !word.equals("The") && !word.equals("and") && !word.equals("is"))
                .toArray(String[]::new);
        // use hashmap to count frequency word ,exclude "the" ,"The","and","is"
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                // if word already exist in hashmap, increment count value
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                // if word not exist in hashmap, add word to hashmap with count value 1
                wordMap.put(word, 1);
            }
        }

        // use hashSet to store unique word
        Set<String> wordSet = new HashSet<String>(Arrays.asList(words));
        // print wordset
        for (String word : wordSet) {
            System.out.println(word + "\t\t" + wordMap.get(word));
        }
    }
}