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

	public int numSetBitsBetter(long a) {
		long num = 1;
		int count = 0;
		while (num <= a) {
			if ((a & num) >= num) {
				count++;
			}
			num = num * 2;
		}
		return count;
	}
	
}