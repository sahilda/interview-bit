/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class AddTwoNumbersAsLists {
	public ListNode addTwoNumbers(ListNode a, ListNode b) {
	    
	    ListNode head = null;
	    ListNode prev = null;
	    ListNode curA = a;
	    ListNode curB = b;
	    int carry = 0;
	    
	    while (curA != null || curB != null || carry != 0) {
	        int sum = carry;
	        if (curA != null) {
	            sum += curA.val;
	        }
	        if (curB != null) {
	            sum += curB.val;
	        }
	        
	        int remainder = sum % 10;
	        carry = sum / 10;
	        ListNode node = new ListNode(remainder);
	        if (head == null) {
	            head = node;
	        }
	        if (prev != null) {
	            prev.next = node;
	        }
	        prev = node;
	        if (curA != null) {
	            curA = curA.next;   
	        }
	        if (curB != null) {
	            curB = curB.next;
	        }
	    }
	    return head;
	}
}
