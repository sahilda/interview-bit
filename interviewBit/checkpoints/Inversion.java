// O(n^2)
public class BruteForce {
    
	public int countInversions(ArrayList<Integer> a) {
	    if (a == null || a.size() == 0) {
	        return 0;
	    }
	    int count = 0;
	    Integer min = null;
	    Integer max = null;
	    for (int i = 0; i < a.size(); i++) {
	        if (min == null) {
	            min = a.get(i);
	            max = a.get(i);
	        } else {
	            if (a.get(i) > max) {
	                max = a.get(i);
	            } else if (a.get(i) < min) {
	                min = a.get(i);
	                count += i;
	            } else {
	                for (int j = 0; j < i; j++) {
	                    if (a.get(j) > a.get(i)) {
	                        count++;
	                    }
	                }
	            }
	        }
	    }
	    return count;
	}	
	
}

// O(n^2)
class TwoHeap {
    
	public int countInversions(ArrayList<Integer> a) {
	    if (a == null || a.size() == 0) {
	        return 0;
	    }
	    int count = 0;
	    PriorityQueue<Integer> upper = new PriorityQueue<>();
	    PriorityQueue<Integer> lower = new PriorityQueue<>(
	        new Comparator<Integer>() {
	            public int compare(Integer a, Integer b) {
	                return -1 * a.compareTo(b);
	       }
	    });
	    for (int i = 0; i < a.size(); i++) {
	        count += find(a.get(i), lower, upper);
	        add(a.get(i), lower, upper);
	    }
	    return count;
	}
	
	private int find(int a, PriorityQueue<Integer> lower, PriorityQueue<Integer> upper) {
	    if (lower.size() == 0) {
	        return 0;
	    }
	    
	    if (lower.peek() > a) {
	        PriorityQueue<Integer> dup = new PriorityQueue<>(lower);
            int count = 0;
            while (dup.size() > 0 && dup.peek() > a) {
                dup.poll();
                count++;
            }
            return count + upper.size();
	    } else {
	        if (upper.size() == 0) {
	            return 0;
	        } else if (upper.peek() > a) {
	            return upper.size();
	        } else {
	            PriorityQueue<Integer> dup = new PriorityQueue<>(upper);
	            int count = 0;
	            while (dup.size() > 0 && dup.peek() <= a) {
	                dup.poll();
	            }
	            return dup.size();
	        }
	    } 
	    
	}
	
	private void add(int a, PriorityQueue<Integer> lower, PriorityQueue<Integer> upper) {
	    if (lower.size() == 0) {
	        lower.add(a);
	    } else if (upper.size() < lower.size()) {
	        if (a > lower.peek()) {
	            upper.add(a);
	        } else {
	            upper.add(lower.poll());
	            lower.add(a);
	        }
	    } else {
	        if (a < upper.peek()) {
	            lower.add(a);
	        } else {
	            lower.add(upper.poll());
	            upper.add(a);
	        }
	    }
	}

}

