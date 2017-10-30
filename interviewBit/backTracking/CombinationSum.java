public class CombinationSum {
    
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    Collections.sort(a);
	    helper(a, new ArrayList<>(), result, 0, b, 0);
	    
	    return result;
	}
	
	private void helper(ArrayList<Integer> nums, ArrayList<Integer> cur, 
	ArrayList<ArrayList<Integer>> result, int sum, int target, int start) {
	    if (sum > target) {
	        return;
	    }
	    
	    if (sum == target) {
	        if (!result.contains(cur)) {
	            result.add(cur);    
	        }
	        return;
	    }
	    
	    for (int i = start; i < nums.size(); i++) {
	        if (sum + nums.get(i) > target) {
	            return;
	        }
	        cur.add(nums.get(i));
	        sum += nums.get(i);
	        helper(new ArrayList<>(nums), new ArrayList<>(cur), result, sum, target, i);
	        
	        cur.remove(Integer.valueOf(nums.get(i)));
	        sum -= nums.get(i);
	    }
	}
	
}
