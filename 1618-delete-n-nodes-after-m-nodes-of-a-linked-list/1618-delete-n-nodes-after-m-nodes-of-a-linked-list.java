/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while(curr!=null && curr.next!=null)
        {
            for (int i=0; i<m && curr!=null && curr.next!=null; i++)
            {
                curr = curr.next;
            }
            for (int i=0; i<n && curr!=null && curr.next!=null; i++)
            {
                curr.next = curr.next.next;
            }
        }
        return dummy.next;
    }
}