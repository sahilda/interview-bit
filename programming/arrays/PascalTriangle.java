public class PascalTriangle {

	public ArrayList<ArrayList<Integer>> generate(int a) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= a; i++) {
			if (i == 1) {
				ArrayList<Integer> row = new ArrayList<Integer>();
				row.add(1);
				triangle.add(row);
			} else {
				ArrayList<Integer> next = new ArrayList<Integer>();
				ArrayList<Integer> last = triangle.get(i-2);
				for (int j = 0; j < i; j++) {
					int num = 0;
					if (j-1 >= 0) {
						num += last.get(j-1);
					}
					if (j < last.size()) {
						num += last.get(j);
					}
					next.add(num);
				}
				triangle.add(next);
			}
		}
		return triangle;
	}

}
