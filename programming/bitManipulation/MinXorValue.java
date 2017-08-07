public class MinXorValue {
    
    public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 1; i++) {
            int xor = A.get(i) ^ A.get(i + 1);
            min = Math.min(min, xor);
        }
        return min;
    }
    
    public int findMinXorBrute(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int xor = A.get(i) ^ A.get(j);
                min = Math.min(min, xor);
            }
        }
        return min;
    }
    
}
