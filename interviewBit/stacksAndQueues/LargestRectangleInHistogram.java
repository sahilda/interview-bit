public class LargestRectangleInHistogram {
    
	public int largestRectangleArea(ArrayList<Integer> a) {
	    int max = 0;
	    Stack<Integer> stack = new Stack<>();
	    for (int i = 0; i < a.size(); i++) {
	        if (stack.empty() || a.get(i) > a.get(stack.peek())) {
	            stack.push(i);
	        } else {
	            while (!stack.empty() && a.get(stack.peek()) > a.get(i)) {
	                int idx = stack.pop();
	                int h = a.get(idx);
	                int w = stack.empty() ? i : i - stack.peek() - 1;
	                int area = h * w;
	                max = Math.max(max, area);
	            }
	            stack.push(i);
	        }
	    }
	    
	    while (!stack.empty()) {
	        int idx = stack.pop();
	        int h = a.get(idx);
	        int w = stack.empty() ? a.size() : a.size() - stack.peek() - 1;
	        int area = h * w;
	        max = Math.max(max, area);
	    }
	    return max;
	}
	
}
