package com.sahilda.lyft;

import java.util.Scanner;


// To run:
// in the project directory, run './gradlew clean build'.
// run the application with 'cat ~/Desktop/sample-files/sample-input.txt | java -jar ./build/libs/Autocomplete-1.0-SNAPSHOT.jar'.
public class Main {

    public static void main(String[] args) {
        runAutocompleteForStdinWithDictionary();
    }

    // This has a total runtime complexity of O(N dictionary words * L letters in dictionary words). This cost is during
    // the index creation, but has no cost during user autocomplete search. Alternative solution with more time than
    // using a hashmap for the index creation would be using a trie (https://en.wikipedia.org/wiki/Trie).
    private static void runAutocompleteForStdinWithDictionary() {
        // Reads from stdin and processes the input
        Scanner scanner = new Scanner(System.in);
        InputProcessor inputProcessor = new InputProcessor();
        inputProcessor.processInput(scanner);

        // Creates the index with the dictionary words
        IndexCreator indexCreator = new IndexCreator(inputProcessor.dictWords);

        // Creates object that runs autocompleter
        Autocompleter autocompleter = new Autocompleter(indexCreator.indexedDictWords);

        // Run through all input words and print results
        for (String word : inputProcessor.inputWords) {
            autocompleter.getRelevantWords(word);
            System.out.println();
        }
    }

}
