public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String a) {
	    if (a == null || a.length() == 0) {
	        return 0;
	    }
	    int max = 0;
	    int cur = 0;
	    int start = 0;
	    HashMap<String, Integer> map = new HashMap<>();
	    for (int i = 0; i < a.length(); i++) {
	        String c = a.substring(i, i + 1);
	        
	        if (map.containsKey(c) && map.get(c) >= start) {
	            int cIdx = map.get(c);
	            cur = i - cIdx;
	            start = cIdx + 1;
	        } else {
	            cur++;
	        }
	        
	        map.put(c, i);
	        if (cur > max) {
	            max = cur;
	        }
	    }
	    return max;
	}
	
}