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
    public int getDecimalValue(ListNode head) {
        ListNode rev = reverse(head);
        int base = 1;
        int answer = 0;
        ListNode curr = rev;
        while(curr!=null)
        {
            if (curr.val==1)
            {
                answer += base;
            }
            curr = curr.next;
            base *= 2;
        }
        return answer;
    }

    private ListNode reverse(ListNode head)
    {
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}