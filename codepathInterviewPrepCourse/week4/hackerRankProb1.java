// Write out the Pascal Triangle for a given k

public class Solution {

/*
 * Complete the function below.
 */

    static void pascalTriangle(int k) {
        HashMap<Integer, Long> factorials = new HashMap<>();
        HashMap<ArrayList<Integer>, Long> pairFactorials = new HashMap<>();        
        ArrayList<ArrayList<Long>> triangle = new ArrayList<>();
        for (int r = 0; r < k; r++) {
            ArrayList<Long> row = new ArrayList<>();
            for (int c = 0; c < r + 1; c++) {
                long num;
                if (r - c > c) {
                    num = getFactorial(r, r - c, pairFactorials) / getFactorial(c, factorials);                    
                } else {
                    num = getFactorial(r, c, pairFactorials) / getFactorial(r - c, factorials);                    
                }
                row.add(num);
            }
            triangle.add(row);
        }        
        printTriangle(triangle);        
    }

    private static void printTriangle(ArrayList<ArrayList<Long>> triangle) {
        for (int i = 0; i < triangle.size(); i++) {
            ArrayList<Long> row = triangle.get(i);
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < row.size(); j++) {
                long num = row.get(j);
                sb.append(num + " ");
            }
            System.out.println(sb.toString());
        }
    }
    
    private static long getFactorial(int k, HashMap<Integer, Long> map) {
        if (k == 0 || k == 1) {
            return 1L;
        } else if (map.containsKey(k)) {
            return map.get(k);
        }        
        long factorial = k * getFactorial(k - 1, map);
        map.put(k, factorial);        
        return factorial;
    }

    private static long getFactorial(int k, int c, HashMap<ArrayList<Integer>, Long> map) {
        ArrayList<Integer> pair = new ArrayList<>();
        pair.add(k);
        pair.add(c);
        if (k == 0 || k == 1) {
            return 1L;
        } else if (map.containsKey(pair)) {
            return map.get(pair);
        } 
        
        if (k == c) {
            return 1;
        }
        long factorial = k * getFactorial(k - 1, c, map);
        map.put(pair, factorial);        
        return factorial;
    }

}

