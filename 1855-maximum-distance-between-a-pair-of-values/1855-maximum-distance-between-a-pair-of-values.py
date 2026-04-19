class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        j = 0
        ans = 0
        for i, n1 in enumerate(nums1):
            while j < len(nums2) and n1 <= nums2[j]:
                ans = max(ans, j-i)
                j += 1
        return ans