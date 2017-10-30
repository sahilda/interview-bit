public class DiffkII {

	public int diffPossible(final List<Integer> a, int b) {
	   HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	   for (int i = 0; i < a.size(); i++) {
	       Integer cur = a.get(i);
	       if (map.containsKey(cur)) {
	           return 1;
	       }
	       int diffA = b + cur;
	       int diffB = cur - b;
	       map.put(diffA, 1);
	       map.put(diffB, 1);
	   }
	   return 0;
	}

}
