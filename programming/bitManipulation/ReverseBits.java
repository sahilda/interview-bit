public class ReverseBits {
    
	public long reverse(long a) {
	    long result = 0L;
	    for (int i = 0; i < 32; i++) {
	        if (a % 2 == 1) {
	            result++; 
	        }
	        a = a >> 1;
	        result = result << 1;
	    }
	    result = result >> 1;
	    return result;
	}
	
}
