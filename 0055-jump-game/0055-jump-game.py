class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_reach = nums[0]
        for i, x in enumerate(nums):
            if max_reach < i:
                return False
            max_reach = max(max_reach, i+x)
            if max_reach >= len(nums)-1:
                return True
        return False
        