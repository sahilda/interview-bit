public class Combinations {
	
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    if (k <= n) {
	        helper(1, n - k + 1, k, new ArrayList<Integer>(), result);    
	    }
	    return result;
	}
	
	private void helper(int start, int end, int k, ArrayList<Integer> current, 
	ArrayList<ArrayList<Integer>> result) {
	    if (current.size() == k) {
	        result.add(new ArrayList<Integer>(current));
	        return;
	    }
	    
	    for (int i = start; i <= end; i++) {
	        current.add((Integer) i);
	        helper(i + 1, end + 1, k, current, result);    
	        current.remove((Integer) i);
	    }
	    
	}
	
}
