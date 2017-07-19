public class LengthOfLastWord {

    public LengthOfLastWord() {

    }

    public int lengthOfLastWord(final String a) {
        int lastWord = 0;
        int wordLength = 0;
        for (char c : a.toCharArray()) {
            if (c == ' ') {
                if (wordLength > 0) {
                    lastWord = wordLength;
                }
                lastWord = wordLength;
                wordLength = 0;
            } else {
                wordLength += 1;
            }
        }

        if (wordLength > 0) {
            return wordLength;
        }
        return lastWord;
    }

    public static void main(String args[]) {
        LengthOfLastWord word = new LengthOfLastWord();
        System.out.print(word.lengthOfLastWord("hello world "));
    }

}
