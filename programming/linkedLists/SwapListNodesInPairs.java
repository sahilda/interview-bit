/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class SwapListNodesInPairs {

	public ListNode swapPairs(ListNode a) {
	    if (a.next == null) {
	        return a;
	    }
	    
	    ListNode prev = null;
	    ListNode cur = a;
	    ListNode next = a.next;
	    ListNode head = next;
	    
	    while(next != null && cur != null) {
	        cur.next = next.next;
	        next.next = cur;
	        if (prev != null) {
	            prev.next = next;
	        }
	        prev = cur;
	        cur = cur.next;
	        if (cur != null) {
	            next = cur.next;
	        }
	    }
	    return head;
	}

}
