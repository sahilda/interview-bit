public class NumberOf1Bits {

	public int numSetBits(long a) {
	    int count = 0;
	    long i = 0;
	    while (true) {
	        long num = (long) Math.pow(2, i);
	        if (num > a) {
	            break;
	        }
	        if ((num & a) == num) {
	            count++;
	        }
	        i++;
	    }
	    return count;
	}
	
}
