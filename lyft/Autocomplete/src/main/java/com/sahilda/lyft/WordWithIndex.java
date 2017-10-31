package com.sahilda.lyft;

// A wrapper class to capture the index along with the word
public class WordWithIndex implements Comparable<WordWithIndex> {

    public String word;
    public int index;

    public WordWithIndex(String word, int index) {
        this.word = word;
        this.index = index;
    }

    // Overridden to allow list sort by the index of this object
    @Override
    public int compareTo(WordWithIndex o) {
        if (this.index < o.index) {
            return -1;
        } else if (this.index == o.index) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        String output = word + " (" + index + ")";
        return output;
    }

}
