public class GenerateAllParentheses {
    
	public ArrayList<String> generateParenthesis(int a) {
	    ArrayList<String> result = new ArrayList<>();
	    helper(a, a, "", result);
	    Collections.sort(result);
	    return result;
	}
	
	private void helper(int open, int close, String cur, ArrayList<String> result) {
	    if (open == 0 && close == 0) {
	        result.add(cur);
	    }
	    
	    if (open > 0) {
	        String x = cur + "(";
	        helper(open - 1, close, x, result);
	    }
	    
	    if (close > open) {
	        String x = cur + ")";
	        helper(open, close - 1, x, result);
	    }
	}
	
}
