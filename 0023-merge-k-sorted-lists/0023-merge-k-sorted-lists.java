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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        Queue<ListNode> heap = new PriorityQueue<>((a,b)->(a.val-b.val));
        for (ListNode ll : lists)
        {
            if (ll!=null)
            {
                heap.offer(ll);
            }
        }
        while(!heap.isEmpty())
        {
            ListNode curr = heap.poll();
            ListNode next = curr.next;
            curr.next = null;
            node.next = curr;
            node = node.next;
            if (next!=null)
            {
                heap.offer(next);
            }
        }
        return dummy.next;
    }
}