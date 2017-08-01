public class AllocateBooks {

	public int books(ArrayList<Integer> a, int b) {
	    if (b > a.size()) {
	        return -1;
	    }
	    
	    int sum = 0;
	    for (Integer i : a) {
	        sum += i;
	    }
	    
	    int low = 0;
	    int high = sum;
	    int max = sum;
	    
	    while (low <= high) {
	        int mid = (high + low) / 2;
	        if (isPossible(a, b, mid)) {
	            max = Math.min(max, mid);
	            high = mid - 1;
	        } else {
	            low = mid + 1;
	        }
	    }
	    
	    return max;
	}
	
	private boolean isPossible(ArrayList<Integer> a, int b, int pages) {
	    int count = 1;
	    int sum = 0;
	    for (Integer i : a) {
	        if (i > pages) {
	            return false;
	        } else if (sum + i > pages) {
	            count++;
	            sum = i;
	            if (count > b) {
	                return false;
	            }
	        } else {
	            sum += i;
	        }
	    }
	    return true;
	}

}
