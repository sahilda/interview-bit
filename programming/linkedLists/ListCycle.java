/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ListCycle {
    
	public ListNode detectCycle(ListNode a) {
	    ListNode a1 = a;
	    ListNode a2 = a.next;
	    ListNode cycle = null;
	    while (a1 != null && a2 != null) {
	        if (a1.equals(a2)) {
	            cycle = a1;
	            break;
	        }
	        a1 = a1.next;
	        if (a2.next != null) {
	            a2 = a2.next.next;    
	        } else {
	            a2 = a2.next;
	        }
	    }
	    
	    if (cycle != null) {
	        int cycleSize = 2;
	        ListNode next = cycle.next;
	        while (true) {
	            if (cycle.equals(next)) {
	                break;
	            }
	            cycleSize++;
	            next = next.next;
	        }
	        
	        ListNode start = a;
	        cycle = a;
	        for (int i = 0; i <= cycleSize; i++) {
	                cycle = cycle.next;
	        }
	        while (true) {
	            if (start.equals(cycle)) {
	                return start;
	            }
	            start = start.next;
	            cycle = cycle.next;
	        }
	        
	    }
	    return null;
	}
	
	public ListNode detectCycleHash(ListNode a) {
		HashMap<ListNode, Integer> map = new HashMap<>();
		ListNode node = a;
		while (node != null) {
			if (map.containsKey(node)) {
				break;
			}
			map.put(node, 1);
			node = node.next;
		}
		return node;
	}

}
