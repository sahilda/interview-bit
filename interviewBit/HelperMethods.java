import java.util.ArrayList;

public class HelperMethods {

	public static ArrayList<Integer> makeList(Integer[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();	
		for (Integer i : args) {
			a.add(i);
		}
		return a;
	}

}