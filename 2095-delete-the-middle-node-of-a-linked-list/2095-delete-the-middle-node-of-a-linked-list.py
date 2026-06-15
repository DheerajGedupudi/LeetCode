# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # take connections
        n = 0
        curr = head
        while curr is not None:
            n += 1
            curr = curr.next
        if n == 1:
            return None
        half = n//2
        curr = head
        for _ in range(half-1):
            curr = curr.next
        curr.next = curr.next.next
        return head