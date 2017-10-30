public class DistinctNumbersInWindow {

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (B > A.size()) {
            return list;
        }
        
        int distinct = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < A.size(); i++) {
            int cur = A.get(i);
            int count = 1;
            if (!map.containsKey(cur)) {
                distinct++;
            } else {
                count = map.get(cur) + 1;
            }
            map.put(cur, count);
            if (i >= (B-1)) {
                list.add(distinct);
                int remove = A.get(i - (B - 1));
                count = map.get(remove);
                if (count == 1) {
                    map.remove(remove);
                    distinct--;
                } else {
                    map.put(remove, count - 1);   
                }
            }
        }
        return list;
    }
    
}
