public class RotatedSortedArraySearch {
    
	// DO NOT MODIFY THE LIST
	public int search(final List<Integer> a, int b) {
	    int low = 0;
	    int high = a.size() - 1;
	    int mid;
	    while (low <= high) {
	        mid = low + (high - low) / 2;
	        if (a.get(mid) == b) {
	            return mid;
	        } else if (a.get(mid) > b) {
	            if (a.get(high) > a.get(mid)) {
	                high = mid - 1;    
	            } else {
	                if (a.get(high) >= b) {
	                    low = mid + 1;
	                } else {
	                    high = mid - 1;
	                }
	            }
	        } else if (a.get(mid) < b) {
	            if (a.get(high) > a.get(mid)) {
	                low = mid + 1;    
	            } else {
	                if (a.get(low) <= b) {
	                    low = mid + 1;
	                } else {
	                    high = mid - 1;
	                }
	            }
	        }
	    }
	    return -1;
	}
	
}
