/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class MergeKSortedLists {

	public ListNode mergeKLists(ArrayList<ListNode> a) {
	    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	    for (ListNode head : a) {
	        ListNode cur = head;
	        while (cur != null) {
	            queue.add(cur.val);
	            cur = cur.next;
	        }
	    }
	    
	    ListNode head = null;
	    ListNode cur = null;
	    while (queue.peek() != null) {
	        ListNode next = new ListNode(queue.poll());
	        if (head == null) {
	            head = next;
	        } else {
	            cur.next = next;
	        }
	        cur = next;
	    }
	    
	    return head;
	}

}
