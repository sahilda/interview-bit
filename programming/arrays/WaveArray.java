public class WaveArray {

	public ArrayList<Integer> wave(ArrayList<Integer> a) {
	    if (a.size() <= 1) {
	        return a;
	    }
	    
	    Collections.sort(a);
	    boolean greater = true;
	    for (int i = 0; i < a.size(); i++) {
	        if (i - 1 > 0) {
	            if (greater) {
	                if (a.get(i - 1) > a.get(i)) {
	                    int temp = a.get(i);
	                    a.set(i, a.get(i - 1));
	                    a.set(i - 1, temp);
	                }
	            } else {
	                if (a.get(i) > a.get(i - 1)) {
	                    int temp = a.get(i);
	                    a.set(i, a.get(i - 1));
	                    a.set(i - 1, temp);
	                }
	            }
	        }
	        
	        if (i + 1 < a.size()) {
	            if (greater) {
	                if (a.get(i + 1) > a.get(i)) {
	                    int temp = a.get(i);
	                    a.set(i, a.get(i + 1));
	                    a.set(i + 1, temp);
	                }
	            } else {
	                if (a.get(i) > a.get(i + 1)) {
	                    int temp = a.get(i);
	                    a.set(i, a.get(i + 1));
	                    a.set(i + 1, temp);
	                }
	            }
	        }
	        greater = !greater;
	    }
	    
	    return a;
	}
	
}
