class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:

        def bin_search(start, target) -> int:
            low = start
            high = len(nums2)-1
            best = -1
            while low <= high:
                mid = low + (high-low)//2
                if nums2[mid] >= target:
                    best = mid
                    low = mid+1
                else:
                    high = mid-1 
            return best
        result = 0
        for i, x in enumerate(nums1):
            j = bin_search(i, x)
            result = max(result, j-i)
        return result