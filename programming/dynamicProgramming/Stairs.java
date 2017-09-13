public class Stairs {
    
	public int climbStairs(int a) {
	    Map<Integer, Integer> map = new HashMap<>();
	    map.put(2, 2);
	    map.put(1, 1);
	    return helper(a, map);
	}
	
	private int helper(int steps, Map<Integer, Integer> map) {
	    if (map.containsKey(steps)) {
	        return map.get(steps);
	    } else if (steps < 0) {
	        return 0;
	    }
	    
	    int result = helper(steps - 1, map) + helper(steps - 2, map);
	    map.put(steps, result);
	    return result;
	}
	
}
