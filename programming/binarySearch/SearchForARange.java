public class SearchForARange {
    
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
	    int first = bSearch(a, b, true);
	    int last = bSearch(a, b, false);
	    ArrayList<Integer> output = new ArrayList<Integer>(2);
	    output.add(first);
	    output.add(last);
	    return output;
	}
	
	private int bSearch(List<Integer> a, int b, boolean first) {
	    int low = 0;
	    int high = a.size() - 1;
	    int idx = -1;
	    while (low <= high) {
	        int mid = low + (high - low) / 2;
	        if (a.get(mid) == b) {
	            idx = mid;
	            if (first) {
	                high = mid - 1;
	            } else {
	                low = mid + 1;
	            }
	        } else if (a.get(mid) > b) {
	            high = mid - 1;
	        } else {
	            low = mid + 1;
	        }
	    }
	    return idx;
	}
	
}
