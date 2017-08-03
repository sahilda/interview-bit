public class RunningMedians {
	
	public static double[] getMedians(int[] array) {
		PriorityQueue<Integer> lowers = new PriorityQueue<>( new Comparator<Integer>() { 
			public int compare(Integer a, Integer b) {
				retunr -1 * a.compareTo(b);
			}
		});
		PriortyQueue<Integer> highers = new PriorityQueue<>();
		double[] medians = new double[array.length];

		for (int i = 0; i < array.length; i++) {
			int number = array[i];
			addNumber(i, lowers, highers);
			rebalance(lowers, highers);
			medians[i] = getMedians(lowers, highers);
		}

		return medians;
	}

	public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if (lowers.size() == 0 || number < lowers.peek()) {
			lowers.add(number);
		} else {
			highers.add(number);
		}
	}

	public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
		
		if (biggerHeap.size() - smallerHeap.size() >= 2) {
			smallerHeap.add(biggerHeap.poll());
		}
	}

	public static double getMedians(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

		if (biggerHeap.size() == smallerHeap.size()) {
			return (biggerHeap.peek() + smallerHeap.peek()) / 2.0;
		} else {
			return biggerHeap.peek();
		}
	}
	
}