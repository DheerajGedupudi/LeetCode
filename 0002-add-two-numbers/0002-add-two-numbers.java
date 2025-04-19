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
        while(curr1!=null && curr2!=null)
        {
            int x = curr1.val;
            int y = curr2.val;
            int sum = x+y+carry;
            ListNode newNode = new ListNode(sum%10);
            node.next = newNode;
            node = newNode;
            carry = sum/10;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while(curr1!=null)
        {
            int x = curr1.val;
            int sum = x+carry;
            ListNode newNode = new ListNode(sum%10);
            node.next = newNode;
            node = newNode;
            carry = sum/10;
            curr1 = curr1.next;
        }
        while(curr2!=null)
        {
            int y = curr2.val;
            int sum = y+carry;
            ListNode newNode = new ListNode(sum%10);
            node.next = newNode;
            node = newNode;
            carry = sum/10;
            curr2 = curr2.next;
        }
        if (carry>0)
        {
            ListNode newNode = new ListNode(carry);
            node.next = newNode;
        }
        return dummy.next;
    }
}