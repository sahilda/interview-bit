package com.sahilda.lyft;

import java.util.ArrayList;
import java.util.Scanner;


//This class processes the input from stdin as per specifications to Automcomplete problem
//and creates a list with the given inputs
public class InputProcessor {

    ArrayList<WordWithIndex> dictWords;
    ArrayList<String> inputWords;

    public InputProcessor() {
        dictWords = new ArrayList<>();
        inputWords = new ArrayList<>();
    }

    public void processInput(Scanner scanner) {
        try {
            int dictWordsCount = scanner.nextInt();
            int inputWordsCount = scanner.nextInt();

            for (int i = 0; i < dictWordsCount; i++) {
                String word = scanner.next();
                WordWithIndex wordWithIndex = new WordWithIndex(word, i + 1);
                dictWords.add(wordWithIndex);
            }

            for (int i = 0; i < inputWordsCount; i++) {
                String word = scanner.next();
                inputWords.add(word);
            }
        } catch (Exception e) {
            System.out.println("ERROR: input not to specified format");
        }
    }

}
