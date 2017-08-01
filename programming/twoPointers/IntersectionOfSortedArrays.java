public class IntersectionOfSortedArrays {

	// DO NOT MODIFY THE LISTS
	public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
	    ArrayList<Integer> intersection = new ArrayList<Integer>();
	    int idxA = 0;
	    int idxB = 0;
	    while (idxA < a.size() && idxB < b.size()) {
	        if (a.get(idxA) < b.get(idxB)) {
	            idxA++;
	        } else if (a.get(idxA).equals(b.get(idxB))) {
	            intersection.add(a.get(idxA));
	            idxA++;
	            idxB++;
	        } else {
	            idxB++;
	        }
	    }
	    return intersection;
	}

}
