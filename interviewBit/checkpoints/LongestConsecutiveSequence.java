public class LongestConsecutiveSequence {
    
	public int longestConsecutive(final List<Integer> a) {
	    if (a == null || a.size() == 0) {
	        return 0;
	    }
	    int max = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < a.size(); i++) {
            minHeap.add(a.get(i));
        }
        
        int cur = minHeap.poll();
        int size = 1;
        while (!minHeap.isEmpty()) {
            int next = minHeap.poll();
            if (next == cur) {
                // do nothing
            } else if (next == cur + 1) {
                size++;
            } else {
                size = 1;
            }
            cur = next;
            max = Math.max(max, size);
        }
        return Math.max(max, size);
	}
	
}
