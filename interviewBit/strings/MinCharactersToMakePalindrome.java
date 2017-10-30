public class MinCharactersToMakePalindrome {
    
    public int solve(String A) {
        if (isPalindrome(A)) {
            return 0;
        }
        String b = A + " " + new StringBuffer(A).reverse().toString();
        int lps = getLastLPS(b);
        return A.length() - lps;
    }
    
    private int getLastLPS(String a) {
        int lps = 0;
        int i = a.length() - 1;
        String word = a.substring(0, i + 1);
        for (int j = 0; j < i; j++) {
            String prefix = word.substring(0, j + 1);
            String suffix = word.substring(word.length() - prefix.length(), word.length());
            if (suffix.equals(prefix)) {
                lps = Math.max(lps, j + 1);
            }
        }
        return lps;
    }
    
    private int[] getLPS(String a) {
        int[] lps = new int[a.length()];
        lps[0] = 0;
        for (int i = 1; i < a.length(); i++) {
            int count = 0;
            String word = a.substring(0, i + 1);
            for (int j = 0; j < i; j++) {
                String prefix = word.substring(0, j + 1);
                String suffix = word.substring(word.length() - prefix.length(), word.length());
                if (suffix.equals(prefix)) {
                    count = Math.max(count, j + 1);
                }
            }
            lps[i] = count;
        }
        return lps;
    }
    
    private boolean isPalindrome(String A) {
        if (A == null || A.length() == 1) {
            return true;
        }
        for (int i = 0; i < A.length() / 2; i++) {
            if (A.charAt(i) != A.charAt(A.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    
}
