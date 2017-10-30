public class NextGreater {
    
    public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
	    int[] result = new int[a.size()];
	    Stack<Integer> stack = new Stack<>();
	    
	    for (int i = 0; i < a.size(); i++) {
	        if (stack.empty() || a.get(i) < a.get(i-1)) {
	            stack.push(i);
	        } else {
	            while (!stack.empty() && a.get(i) > a.get(stack.peek())) {
	                result[stack.pop()] = a.get(i);
	            }
	            stack.push(i);
	        }
	    }
	    
	    while (!stack.empty()) {
	        result[stack.pop()] = -1;
	    }
	    ArrayList<Integer> list = new ArrayList<Integer>();
        for (Integer i : result) {
            list.add(i);
        }
        return list;
	}

	public ArrayList<Integer> nextGreaterBrute(ArrayList<Integer> a) {
	    ArrayList<Integer> result = new ArrayList<>();
	    for (int i = 0; i < a.size() - 1; i++) {
	        int val = a.get(i);
	        boolean added = false;
	        for (int j = i + 1; j < a.size(); j++) {
	            if (a.get(j) > val) {
	                result.add(a.get(j));
	                added = true;
	                break;
	            }
	        }
	        if (!added) {
	            result.add(-1);
	        }
	    }
	    result.add(-1);
	    return result;
	}

}
