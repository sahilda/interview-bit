import java.util.List;
import java.util.ArrayList;

public class KthSmallest {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int kthsmallest(final List<Integer> a, int k) {
		int answer = -1, i = 0;

        while (answer == -1) {
            int num = a.get(i);
            int smaller = 0;
            int same = 0;

            for (Integer n : a) {
                if (n < num) {
                    smaller += 1;
                } else if (n == num) {
                    same += 1;
                }

                if (smaller >= k) {
                    break;
                }
            }

            if (smaller < k && k <= smaller + same) {
                answer = num;
                return answer;
            }

            i++;
            if (smaller >= k) {
                while (a.get(i) >= num) {
                    i++;
                }
            } else {
                while (a.get(i) <= num) {
                    i++;
                }
            }
        }

        return answer;
	}

	public int kthsmallestB(final List<Integer> a, int k) {
		List<Integer> b = heapSort(a);
		return b.get(k-1);
	}

	public List<Integer> heapSort(List<Integer> a) {
		int size = a.size();
		List<Integer> b = new ArrayList<Integer>(a);
		for (int i = size / 2 + 1; i >= 0; i--) {
			heapify(b, size, i);
		}

		for (int i = size - 1; i >= 0; i--) {
			Integer temp = b.get(0);
			b.set(0, b.get(i));
			b.set(i, temp);
			heapify(b, i, 0);
		}

		return b;
	}

	public void heapify(List<Integer> a, int size, int i) {
		int largest = i;
		int left = i * 2 + 1;
		int right = i * 2 + 2;

		if (left < size && a.get(left) > a.get(largest)) {
			largest = left;
		}

		if (right < size && a.get(right) > a.get(largest)) {
			largest = right;
		}

		if (largest != i) {
			Integer temp = a.get(i);
			a.set(i, a.get(largest));
			a.set(largest, temp);

			heapify(a, size, largest);
		}
	}

	public KthSmallest() {

	}

	public static void main(String[] args) {
		KthSmallest ks = new KthSmallest();
		int answer = ks.kthsmallest(makeSmallList(), 3);
		System.out.print(answer + "\n");
		answer = ks.kthsmallest(makeLargeList(), 19);
		System.out.print(answer + "\n");

		List<Integer> list = makeLargeList();
		System.out.print(list + "\n");
		ks.heapSort(list);
		System.out.print(list + "\n");
		System.out.print(ks.kthsmallestB(makeLargeList(), 19) + "\n");
	}

	public static List<Integer> makeSmallList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(2);
		return list;
	}

	public static List<Integer> makeLargeList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(94);
		list.add(87);
		list.add(100);
		list.add(11);
		list.add(23);
		list.add(98);
		list.add(17);
		list.add(35);
		list.add(43);
		list.add(66);
		list.add(34);
		list.add(53);
		list.add(72);
		list.add(80);
		list.add(5);
		list.add(34);
		list.add(64);
		list.add(71);
		list.add(9);
		list.add(16);
		list.add(41);
		list.add(66);
		list.add(96);
		return list;
	}

}
