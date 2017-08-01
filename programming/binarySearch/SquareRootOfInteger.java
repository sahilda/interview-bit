public class SquareRootOfInteger {
	
	public int sqrt(int a) {
	    if (a <= 0) {
	        return 0;
	    }
	    int low = 1;
	    int high = a / 2 + 1;
	    int mid;
	    while (true) {
	        mid = low + (high - low) / 2;
	        if ((long) mid * mid <= a && ((long) mid + 1) * (mid + 1) > a) {
	            return mid;
	        } else if (mid * (long) mid > a) {
	            high = mid;
	        } else {
	            low = mid;
	        }
	    }
	}
	
}
