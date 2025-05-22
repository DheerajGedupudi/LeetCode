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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        int carry = 0;
        while(curr1!=null || curr2!=null || carry!=0)
        {
            int x = 0;
            int y = 0;
            if (curr1!=null)
            {
                x = curr1.val;
                curr1 = curr1.next;
            }
            if (curr2!=null)
            {
                y = curr2.val;
                curr2 = curr2.next;
            }
            int sum = x+y+carry;
            ListNode newNode = new ListNode(sum%10);
            node.next = newNode;
            node = newNode;
            carry = sum/10;
        }
        return dummy.next;
    }
}