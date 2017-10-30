import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class SingleNumber {

	public SingleNumber() {

	}

	// DO NOT MODIFY THE LIST
	public int singleNumber(final List<Integer> a) {
		int answer = 0;

		for (Integer i : a) {
			answer += i;
		}

		String binary = Integer.toBinaryString(answer);
		System.out.print(binary);
		//System.out.print(answer);
		return 1;
	}

	public int singleNumberNaive(final List<Integer> a) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int answer = -1;

		for (Integer i : a) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		for (Integer key : map.keySet()) {
			if (map.get(key) == 1) {
				answer = key;
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		SingleNumber singleNumber = new SingleNumber();
		List<Integer> a = new ArrayList();
		a.add(1);
		a.add(1);
		a.add(2);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(4);

		int output = singleNumber.singleNumber(a);
		//System.out.print(output);
	}

}
