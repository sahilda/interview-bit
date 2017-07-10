public class Subtract {

	public ListNode subtract(ListNode a) {
		int size = getSize(a);
		int midIndex = size / 2;	
		if (size % 2 != 0) {
			midIndex = midIndex + 1;
		}
		ListNode mid = a;
		for (int i = 0; i < midIndex; i++) {
			mid = mid.next;
		}
		ListNode head = a;
		ListNode tail = mid;
		for (int i = 0; i < size / 2; i++) {
			for (int j = 0; j < size / 2 - i - 1; j++) {
				tail = tail.next;
			}
			head.val = tail.val - head.val;
			head = head.next;
			tail = mid;
		}
		return a;
	}

	public int getSize(ListNode a) {
		int size = 0;
		ListNode head = a;
		while (head != null) {
			size++;
			head = head.next;
		}
		return size;
	}

	public ListNode subtractB(ListNode a) {
		int size = getSize(a);
		ArrayList<Integer> al = new ArrayList<Integer>();
		ListNode head = a;
		while (head != null) {
			al.add(head.val);
			head = head.next;
		}
		ListNode b = a;
		for (int i = 0; i < size / 2; i++) {
			b.val = al.get(size - 1 - i) - b.val;
			b = b.next;
		}
		return a;	
	}

}

class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}

}
