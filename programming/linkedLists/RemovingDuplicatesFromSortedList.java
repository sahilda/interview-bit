/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class RemoveDuplicatesFromSortedList {

	public ListNode deleteDuplicates(ListNode a) {
	    ListNode cur = a;
	    while (cur.next != null) {
	        if (cur.val == cur.next.val) {
	            cur.next = cur.next.next;
	        } else {
	            cur = cur.next;
	        }
	    }
	    return a;
	}
	
}