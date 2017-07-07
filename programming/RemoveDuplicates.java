import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates {

	public RemoveDuplicates() {

	}

	public int removeDuplicates(ArrayList<Integer> a) {
        int i = 1, index = 1, n = a.size();
        for(; i < n; i++) {
            if (a.get(i).equals(a.get(i-1))) {

            } else {
                a.set(index, a.get(i));
                index++;
            }
        }
        return index;
	}

	public static void main(String[] args) {
		RemoveDuplicates rd = new RemoveDuplicates();
		ArrayList a = new ArrayList<Integer>(Arrays.asList(1,2,2,2,2,3,3,4,5,6,6,7));
		System.out.print(a);

		rd.removeDuplicates(a);
	}

}