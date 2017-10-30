public class GrayCode {
	
	public ArrayList<Integer> grayCode(int a) {
	    ArrayList<Integer> list = helper(a);
	    return list;
	}
	
	private ArrayList<Integer> helper(int a) {
	    if (a == 1) {
	        ArrayList<Integer> current = new ArrayList<>();
	        current.add(0);
	        current.add(1);
	        return current;
	    }
	    
	    ArrayList<Integer> last = helper(a - 1);
	    ArrayList<Integer> reverse = new ArrayList<>(last);
	    Collections.reverse(reverse);
	    int base = (int) Math.pow(2, a - 1);
	    for (Integer i : reverse) {
	        Integer num = base + i;
	        last.add(num);
	    }
	    return last;
	}

}
