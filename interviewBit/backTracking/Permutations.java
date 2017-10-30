public class Permutations {

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
	    for (int i = 0; i < a.size(); i++) {
	        helper(a, i, new ArrayList<Integer>(), output, a.size());
	    }
	    return output;
	}
	
	private void helper(ArrayList<Integer> a, int i, 
	ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> result, int size) {
	    int num = a.get(i % a.size());
	    cur.add(num);
	    if (cur.size() == size) {
	        result.add(new ArrayList<Integer>(cur));
	        return;
	    }
	    ArrayList<Integer> list = new ArrayList<Integer>(a);
	    list.remove((Integer) num);
	    for (int j = 0; j < list.size(); j++) {
	        helper(list, j, new ArrayList<Integer>(cur), result, size);    
	    }
	}
	
}

class CleanerSolution {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();	
    	helper(a, new ArrayList<>(), results);
    	return results;
    }
    
    private void helper(ArrayList<Integer> a, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> results) {
    	if (a.size() == 0) {
    		results.add(cur);
    	}
    
    	for (int i = 0; i < a.size(); i++) {
    		ArrayList<Integer> cur2 = new ArrayList<Integer>(cur);
    		cur2.add(a.get(i));
    		ArrayList<Integer> letters = new ArrayList<Integer>(a);
    		letters.remove(a.get(i));
    		helper(letters, cur2, results);
    	}
    }
	
}

