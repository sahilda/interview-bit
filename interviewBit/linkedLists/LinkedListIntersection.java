public class LinkedListIntersection {

	public ListNode getIntersectionNode(ListNode a, ListNode b) {	
		int aSize = getSize(a);
		int bSize = getSize(b);
		int diff = bSize - aSize;
		if (diff > 0) {
			for (int i = 0; i < diff; i++) {
				b = b.next;
			}
		} else if (diff <  0) {
			for (int i = 0; i < Math.abs(diff); i++) {
				a = a.next;
			}
		}

		while (a != null && b != null) {
			if (a.equals(b)) {
				return a;
			}
			a = a.next;
			b = b.next;
		}

		return null;
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
	
	public ListNode getIntersectionNodeNaive(ListNode a, ListNode b) {	
		ListNode idxA = a;
		while (idxA != null) {
			ListNode idxB = b;
			while (idxB != null) {
				if (idxA.equals(idxB)) {
					return idxA;
				}
				idxB = idxB.next;
			}
			idxA = idxA.next;
		}
		return null;
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