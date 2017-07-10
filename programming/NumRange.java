import java.util.ArrayList;

public class NumRange {

	public static int numRange(ArrayList<Integer> a, int b, int c) {
		int answer = 0;

		for (int i = 0; i < a.size(); i++) {
			int sum = a.get(i);
			int next = i;
			while (sum <= c) {
				if (sum >= b) {
					answer++;
				}				
				next++;
				if (next >= a.size()) {
					break;
				}
				sum += a.get(next);
			}
		}

		return answer;
	}

	public static void main(String args[]) {
		Integer ints[] = {80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90};
		ArrayList<Integer> a = HelperMethods.makeList(ints);
		System.out.print(numRange(a, 99, 268) + "\n");
	}

}