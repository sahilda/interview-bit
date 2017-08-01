public class Subset {

	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
	    Collections.sort(a);
	    ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> blank = new ArrayList<Integer>();
	    output.add(blank);
	    for (int i = 0; i < a.size(); i++) {
	        getSubsets(a, i, new ArrayList<Integer>(), output);
	    }
	    return output;
	}
	
	private void getSubsets(ArrayList<Integer> a, int i, 
    ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> result) {
        if (i >= a.size()) {
            return;
        }
	    cur.add(a.get(i));
	    result.add(new ArrayList<Integer>(cur));
	    for (int j = i + 1; j < a.size(); j++) {
	        getSubsets(a, j, new ArrayList<Integer>(cur), result);    
	    }
	    return;
	}

}
