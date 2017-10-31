package com.sahilda.lyft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Autocompleter {

    public HashMap<String, ArrayList<WordWithIndex>> indexedDictWords;

    public Autocompleter(HashMap<String, ArrayList<WordWithIndex>> indexedDictWords) {
        this.indexedDictWords = indexedDictWords;
    }

    // This returns the (up to) top 5 results for the current based on the WordWithIndex index.
    // This has a running time complexity O(1)
    // Assummes the indexWordList is inserted by frequency / ranking
    public ArrayList<WordWithIndex> getRelevantWords(String word) {
        ArrayList<WordWithIndex> results = new ArrayList<>();
        if (indexedDictWords.containsKey(word)) {
            ArrayList<WordWithIndex> list = indexedDictWords.get(word);
            //Collections.sort(list);
            for (WordWithIndex wordWithIndex : list) {
                if (results.size() == 5) {
                    break;
                }
                results.add(wordWithIndex);
            }
        }
        printResults(word, results);
        return results;
    }

    private void printResults(String word, ArrayList<WordWithIndex> results) {
        System.out.println(word + ":");
        for (WordWithIndex wordWithIndex : results) {
            System.out.println(wordWithIndex);
        }
    }

}
