public class LongestConsecutiveSequence {
	public int longestConsecutive(final List<Integer> a) {
	    int size = a.size();
        Map<Integer, List<Integer>> hash = new HashMap<Integer, List<Integer>>();
        for (Integer i : a) {
            boolean added = false;
            Set<Integer> keys = hash.keySet();
            for (Integer key : keys) {
                if (Math.abs(key - i) < size) {
                    List<Integer> list = hash.get(key);
                    list.add(i);
                    hash.put(key, list);
                    added = true;
                    break;
                }
            }
            if (!added) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                hash.put(i, list);
            }
        }
        int max = 0;
        Collection<List<Integer>> values = hash.values();
        for (List<Integer> list : values) {
            if (list.size() > max) {
                max = list.size();
            }
        }
        return max;
	}
}