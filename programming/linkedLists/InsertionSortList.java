/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class InsertionSortList {

    public ListNode insertionSortList(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }

        ListNode head = a;
        ListNode cur = a.next;
        ListNode prev = a;
        while (cur != null) {
            ListNode idx_prev = null;
            ListNode idx = head;
            ListNode end = cur.next;
            prev.next = cur.next;
            while (idx != end && idx.val <= cur.val) {
                idx_prev = idx;
                idx = idx.next;
            }
            if (idx_prev == null) {
                head = cur;
            } else {
                idx_prev.next = cur;
            }
            cur.next = idx;
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
    
}
