public class MaxSubArray {
	
	public int maxSubArray(final List<Integer> a) {
	    boolean noPositives = true;
	    int minNeg = Integer.MIN_VALUE;
	    for (Integer i : a) {
	    	if (i > 0) {
	    		noPositives = false;
	    		break;
	    	}
	    	if (i > minNeg) {
	    		minNeg = i;
	    	}
	    }
	    if (noPositives) {
	    	return minNeg;
	    }

	    int maxSum = Integer.MIN_VALUE;
	    int currentSum = 0;
	    for (int i = 0; i < a.size(); i++) {
	    	Integer current = a.get(i);
	    	if (currentSum + current <= 0) {
	    		currentSum = 0;
	    	} else {
	    		currentSum += current;
	    		if (currentSum > maxSum) {
	    			maxSum = currentSum;
	    		}
	    	}
	    }
	    return maxSum;
	}

	// DO NOT MODFIY THE LIST. 
	public int bruteMaxSubArray(final List<Integer> a) {	    
	    boolean noPositives = true;
	    int minNeg = Integer.MIN_VALUE;
	    for (Integer i : a) {
	    	if (i > 0) {
	    		noPositives = false;
	    		break;
	    	}
	    	if (i > minNeg) {
	    		minNeg = i;
	    	}
	    }
	    if (noPositives) {
	    	return minNeg;
	    }

	    int maxSum = Integer.MIN_VALUE;
	    int currentSum = 0;
	    for (int i = 0; i < a.size(); i++) {
	    	Integer current = a.get(i);
	    	if (currentSum + current <= 0) {
	    		current = 0;
	    	} else {
	    		currentSum += current;
	    		if (currentSum > maxSum) {
	    			maxSum = currentSum;
	    		}
	    	}
	    }
	    return maxSum;
	}

}
