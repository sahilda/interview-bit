package com.sahilda.lyft;

import java.util.ArrayList;
import java.util.HashMap;

// This class creates the index used for autocomplete.
public class IndexCreator {

    ArrayList<WordWithIndex> dictWords;
    HashMap<String, ArrayList<WordWithIndex>> indexedDictWords;

    public IndexCreator(ArrayList<WordWithIndex> dictWords) {
        this.dictWords = dictWords;
        indexedDictWords = new HashMap<>();
        createIndex();
    }

    // Algorithm: for each word in the dictionary, add all prefixes and the word itself to the dictionary with the
    // key being the prefix, and the value a list of words with said prefix.
    // This has a running time complexity of O(n words * l letters).
    private void createIndex() {
        for (WordWithIndex wordWithIndex : dictWords) {
            for (int i = 1; i <= wordWithIndex.word.length(); i++) {
                String prefix = wordWithIndex.word.substring(0, i);
                if (indexedDictWords.containsKey(prefix)) {
                    ArrayList<WordWithIndex> list = indexedDictWords.get(prefix);
                    list.add(wordWithIndex);
                    indexedDictWords.put(prefix, list);
                } else {
                    ArrayList<WordWithIndex> list = new ArrayList<>();
                    list.add(wordWithIndex);
                    indexedDictWords.put(prefix, list);
                }
            }
        }
    }

    public void printIndex() {
        for (String prefix : indexedDictWords.keySet()) {
            ArrayList<WordWithIndex> list = indexedDictWords.get(prefix);
            StringBuilder sb = new StringBuilder();
            sb.append(prefix + ": ");
            for (WordWithIndex wordWithIndex : list) {
                sb.append(wordWithIndex.word + " ");
            }
            System.out.println(sb.toString());
        }
    }

}
