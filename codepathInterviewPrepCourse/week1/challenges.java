
// challenge 1 - Deleting duplicates from a sorted array
public int removeDuplicates(int[] numbers) {
    if (numbers.size() == 0) {
        return 0;
    } 
    
    int i = 0;
    for (int j = 1; j < numbers.size(); j++) {
        if (numbers[j] != numbers[i]) {
            i++;
            numbers[i] = numbers[j];
        }
    }    
    for (int j = i + 1; j < numbers.size(); j++) {
        numbers[j] = 0;
    }
    
    return i + 1;
}

// challenge 2 - Enumerate all primes <= n
//[2,3 ,4 ,5 ,6 , , ]
public ArrayList<Integer> allPrimes(int n) {
    ArrayList<Integer> primes = new ArrayList<Integer>();    
    if (n < 2) { return primes; }
    primes.add(2);    
    for (int i = 3; i < n; i++) {
        boolean flag = false;
        for (int j = 0; j < primes.size(); j++) {
            if (i%primes.get(j)==0){
                flag = true;
                break;
            }
            
        }
        if (flag == false) {
            primes.add(i);
        }
    
    }
    return primes;
}

// challenge 3 - Spiral Order
public int[] spiralOrder(int[][] matrix) {
    int[] output = int[matrix[0].size() * matrix.size();]
    int top = 0;
    int bottom = matrix.size() - 1;
    int left = 0;
    int right = matrix[0].size() - 1;
    int dir = 0;
    int z = 0;
    while (top > bottom && right > left) {
        if (dir == 0) {
            for (int i = left; i <= right; i++) {
                output[z] = matrix[top][i];
                z++;
            }
            top++;
            dir = 1;
        } else if (dir == 1) {
            for (int i = top; i <= bottom; i++) {
                output[z] = matrix[i][right];
                z++;
            }
            right--;
            dir = 2;
        } else if (dir == 2) {
            for (int i = right; i >= left; i--) {
                output[z] = matrix[bottom][i];
                z++;
            }
            bottom--;
            dir = 3;
        } else if (dir == 3) {
            for (int i = bottom; i >= top; i--) {
                output[z] = matrix[i][left];
                z++;
            }
            left++;
            dir = 4;
        }
    }
    return output;
}

// challenge 4 - Palindrome detection
public boolean isPalindrome(String a) {
    int left = 0;
    int right = a.length() - 1;
    while (left < right) {
        while (a.charAt(left) == ' ') {
            left++;
        }
        while (a.charAt(right) == ' ') {
            right--;
        }
        char leftChar = Character.toLowerCase(a.charAt(left));
        char rightChar = Character.toLowerCase(a.charAt(right));
        if (leftChar != rightChar) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

// challenge 5 - Longest Palindrome Substring
public String longestPalindrome(String a) {


}

// challenge 6 - Longest Common Prefix
public String longestCommonPrefix(String[] input) {
    StringBuffer strBuf = new StringBuffer();
    int maxLength = Integer.MAX_VALUE;
    for (String s : input) {
        if (s.length() < maxLength) {
            maxLength = s.length();
        }
    }

    for (int i = 0; i < maxLength; i++) {
        string prefix = input[0].substring(i, i+1).toLowerCase();
        for (String s : input) {
            if (s.substring(i, i+1).toLowerCase().equals(prefix)) {
                return strBuf.toString();
            }            
        }
        strBuf.append(prefix);
    }
    
    return strBuf.toString();
} 
